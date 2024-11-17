package io.github.luochangcheng.cccloudmybatisplusrepository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.luochangcheng.cccloudmybatisplusrepository.model.user.BaseAuthority;
import io.github.luochangcheng.cccloudmybatisplusrepository.model.user.BaseRole;
import io.github.luochangcheng.cccloudmybatisplusrepository.model.user.SysAdminUserInfoVo;
import io.github.luochangcheng.cccloudmybatisplusrepository.po.SysAdminUserPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 管理端用户 Mapper 接口
 * </p>
 *
 * @author passion
 * @since 2024-11-15 16:25:57
 */
public interface SysAdminUserMapper extends BaseMapper<SysAdminUserPo> {

    SysAdminUserInfoVo selectUser(@Param("username") String username, @Param("password") String password);

    List<BaseRole> selectRolesByUserId(@Param("userId") String userId);

    List<BaseAuthority> selectAuthoritiesByUserId(@Param("userId") String userId);

}
