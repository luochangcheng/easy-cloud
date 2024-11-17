package io.github.luochangcheng.ccclouduser.service;

import io.github.luochangcheng.ccclouduser.http.req.common.AdminUserLoginReq;

public interface IAdminUserService {

    String login(AdminUserLoginReq req);

}
