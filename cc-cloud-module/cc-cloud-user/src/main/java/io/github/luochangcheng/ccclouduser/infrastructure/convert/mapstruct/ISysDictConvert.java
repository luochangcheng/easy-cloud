package io.github.luochangcheng.ccclouduser.infrastructure.convert.mapstruct;

import io.github.luochangcheng.cccloudmybatisplusrepository.po.SysDictPo;
import io.github.luochangcheng.ccclouduser.http.req.common.SysDictModifyReq;
import io.github.luochangcheng.ccclouduser.http.resp.common.SysDictResp;
import org.mapstruct.Mapper;

/**
 * <p>
 * 字典 转换
 * </p>
 *
 * @author passion
 * @since 2024-11-13 11:54:46
 */
@Mapper(componentModel = "spring")
public interface ISysDictConvert {

    /**
     * 字典新增/修改请求体 转 字典
     *
     * @param req 字典新增/修改请求体
     * @return {@link SysDictPo}
     */
    SysDictPo modifyReq2Po(SysDictModifyReq req);

    /**
     * 字典 转 字典响应体
     *
     * @param po 字典
     * @return {@link SysDictResp}
     */
    SysDictResp po2Resp(SysDictPo po);

}
