package io.github.luochangcheng.ccclouduser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.luochangcheng.cccloudmybatisplusrepository.po.SysDictPo;
import io.github.luochangcheng.cccloudstartermybatisplus.utils.page.PageReq;
import io.github.luochangcheng.cccloudstartermybatisplus.utils.page.PageResp;
import io.github.luochangcheng.ccclouduser.http.req.common.SysDictModifyReq;
import io.github.luochangcheng.ccclouduser.http.req.common.SysDictReq;
import io.github.luochangcheng.ccclouduser.http.resp.common.SysDictResp;

import java.util.List;

/**
 * <p>
 * 字典 服务类
 * </p>
 *
 * @author passion
 * @since 2024-11-13 11:54:46
 */
public interface ISysDictService extends IService<SysDictPo> {

    /**
     * 获取字典明细
     *
     * @param id 字典主键
     * @return {@link SysDictResp}
     */
    SysDictResp getDetail(String id);

    /**
     * 获取字典分页
     *
     * @param req 字典请求体
     * @return {@link PageResp}<{@link SysDictResp}>
     */
    PageResp<SysDictResp> getPage(PageReq<SysDictReq> req);

    /**
     * 新增字典
     *
     * @param req 字典新增/修改请求体
     * @return {@link String}
     */
    String create(SysDictModifyReq req);

    /**
     * 修改字典
     *
     * @param req 字典新增-修改请求体
     * @return {@link String}
     */
    String modify(SysDictModifyReq req);

    /**
     * 删除字典
     *
     * @param id 字典主键
     * @return {@link Boolean}
     */
    Boolean delete(List<Long> id);

}
