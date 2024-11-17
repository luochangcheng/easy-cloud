package io.github.luochangcheng.ccclouduser.infrastructure.convert.mapstruct;

import io.github.luochangcheng.cccloudmybatisplusrepository.model.user.SysAdminUserInfoVo;
import io.github.luochangcheng.cccloudstarterauth.model.BaseAuthority;
import io.github.luochangcheng.cccloudstarterauth.model.BaseRole;
import io.github.luochangcheng.cccloudstarterauth.model.BaseUser;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAdminUserConvert {

    BaseUser toBaseUser(SysAdminUserInfoVo user);

    List<BaseRole> toRole(List<io.github.luochangcheng.cccloudmybatisplusrepository.model.user.BaseRole> roles);

    List<BaseAuthority> toAuthority(List<io.github.luochangcheng.cccloudmybatisplusrepository.model.user.BaseAuthority> authorities);

}
