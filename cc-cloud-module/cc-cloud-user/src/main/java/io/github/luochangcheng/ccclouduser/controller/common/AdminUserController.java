package io.github.luochangcheng.ccclouduser.controller.common;

import io.github.luochangcheng.cccloudstarterweb.common.exception.R;
import io.github.luochangcheng.ccclouduser.http.req.common.AdminUserLoginReq;
import io.github.luochangcheng.ccclouduser.service.IAdminUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "公共资源端-管理端用户")
@RestController
@RequestMapping("/common/sys-admin-user")
public class AdminUserController {

    @Autowired
    private IAdminUserService service;

    @PostMapping("/login")
    public R<String> login(@RequestBody AdminUserLoginReq req) {
        return R.ok(service.login(req));
    }

}
