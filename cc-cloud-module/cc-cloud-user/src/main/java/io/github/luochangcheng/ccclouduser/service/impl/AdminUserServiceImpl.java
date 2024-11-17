package io.github.luochangcheng.ccclouduser.service.impl;

import com.google.common.collect.Lists;
import io.github.luochangcheng.cccloudcommoncore.enums.ClientType;
import io.github.luochangcheng.cccloudmybatisplusrepository.mapper.SysAdminUserMapper;
import io.github.luochangcheng.cccloudmybatisplusrepository.model.user.BaseAuthority;
import io.github.luochangcheng.cccloudmybatisplusrepository.model.user.BaseRole;
import io.github.luochangcheng.cccloudmybatisplusrepository.model.user.SysAdminUserInfoVo;
import io.github.luochangcheng.cccloudstarterauth.common.AuthConstants;
import io.github.luochangcheng.cccloudstarterauth.model.BaseUser;
import io.github.luochangcheng.cccloudstarterauth.utils.JwtTokenUtil;
import io.github.luochangcheng.cccloudstarterredis.utils.RedisUtil;
import io.github.luochangcheng.cccloudstarterweb.common.enums.ApiErrorCode;
import io.github.luochangcheng.cccloudstarterweb.common.exception.ApiException;
import io.github.luochangcheng.ccclouduser.http.req.common.AdminUserLoginReq;
import io.github.luochangcheng.ccclouduser.infrastructure.convert.mapstruct.IAdminUserConvert;
import io.github.luochangcheng.ccclouduser.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AdminUserServiceImpl implements IAdminUserService {

    @Autowired
    private SysAdminUserMapper sysAdminUserMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IAdminUserConvert convert;
    @Autowired
    private RedisUtil<BaseUser> redisUtil;

    @Override
    public String login(AdminUserLoginReq req) {
        SysAdminUserInfoVo user = sysAdminUserMapper.selectUser(req.userName(), req.password());
        if (user == null) {
            throw new ApiException(ApiErrorCode.USERNAME_OR_PASSWORD_ERROR);
        }
        BaseUser baseUser = convert.toBaseUser(user);
        List<CompletableFuture<Void>> futures = Lists.newArrayList();
        futures.add(CompletableFuture.runAsync(() -> {
            //查询角色
            List<BaseRole> roles = sysAdminUserMapper.selectRolesByUserId(user.getUserId());
            baseUser.setRoles(convert.toRole(roles));
        }));
        futures.add(CompletableFuture.runAsync(() -> {
            //查询权限
            List<BaseAuthority> authorities = sysAdminUserMapper.selectAuthoritiesByUserId(user.getUserId());
            baseUser.setAuthorities(convert.toAuthority(authorities));
        }));
        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[]{}));
        all.join();
        String token = jwtTokenUtil.createToken(baseUser);
        baseUser.setToken(token);
        redisUtil.set(String.format(AuthConstants.CACHE_NAME_LOGIN_FORMAT, user.getUserId(), ClientType.ADMIN.getCode()), baseUser, jwtTokenUtil.getProperties().getTokenExpireTime());
        return token;
    }

}
