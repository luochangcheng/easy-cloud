package io.github.luochangcheng.cccloudmybatisplusrepository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.luochangcheng.cccloudmybatisplusrepository.po.SysDictPo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 字典 Mapper 接口
 * </p>
 *
 * @author passion
 * @since 2024-11-13 11:54:43
 */
public interface SysDictMapper extends BaseMapper<SysDictPo> {

    SysDictPo getDetail(@Param("id") String id);

}
