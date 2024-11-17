package io.github.luochangcheng.ccclouduser.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.luochangcheng.cccloudmybatisplusrepository.mapper.SysDictMapper;
import io.github.luochangcheng.cccloudmybatisplusrepository.po.SysDictPo;
import io.github.luochangcheng.cccloudstartermybatisplus.utils.page.PageReq;
import io.github.luochangcheng.cccloudstartermybatisplus.utils.page.PageResp;
import io.github.luochangcheng.cccloudstartermybatisplus.utils.page.PageUtil;
import io.github.luochangcheng.ccclouduser.http.req.common.SysDictModifyReq;
import io.github.luochangcheng.ccclouduser.http.req.common.SysDictReq;
import io.github.luochangcheng.ccclouduser.http.resp.common.SysDictResp;
import io.github.luochangcheng.ccclouduser.infrastructure.convert.mapstruct.ISysDictConvert;
import io.github.luochangcheng.ccclouduser.service.ISysDictService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 字典 服务实现类
 * </p>
 *
 * @author passion
 * @since 2024-11-13 11:54:46
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictPo> implements ISysDictService {

    @Autowired
    private ISysDictConvert convert;
    @Autowired
    private SysDictMapper dictMapper;

    @Override
    public SysDictResp getDetail(String id) {
        SysDictPo byId = dictMapper.getDetail(id);
        return convert.po2Resp(byId);
    }

    @Override
    public PageResp<SysDictResp> getPage(PageReq<SysDictReq> req) {
        Page<SysDictPo> toPage = PageUtil.toPage(req);
        Wrapper<SysDictPo> wrapper = commonWrapper(req.getFilterData());
        Page<SysDictPo> page = page(toPage, wrapper);
        return PageUtil.toPageResp(page, convert::po2Resp);
    }

    @Override
    public String create(SysDictModifyReq req) {
        SysDictPo po = convert.modifyReq2Po(req);
        save(po);
        return po.getId();
    }

    @Override
    public String modify(SysDictModifyReq req) {
        SysDictPo po = convert.modifyReq2Po(req);
        updateById(po);
        return po.getId();
    }

    @Override
    @Transactional
    public Boolean delete(List<Long> id) {
        return CollectionUtils.isEmpty(id) ? Boolean.FALSE : removeBatchByIds(id);
    }

    /**
     * 公共查询条件
     *
     * @param req 字典请求体
     * @return {@link Wrapper}<{@link SysDictPo}>
     */
    private Wrapper<SysDictPo> commonWrapper(SysDictReq req) {
        return Wrappers.<SysDictPo>lambdaQuery();
    }

}
