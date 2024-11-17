package io.github.luochangcheng.cccloudmanage.controller.admin;

import io.github.luochangcheng.cccloudstarterauth.common.AuthConstants;
import io.github.luochangcheng.cccloudstarterauth.common.annotation.HasAuthority;
import io.github.luochangcheng.cccloudstarterweb.common.exception.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController("admin-test")
@RequestMapping("/admin/test")
@Tag(name = "平台管理端-测试")
public class TestController {

    @Operation(summary = "查看当前时间")
    @GetMapping("/hello")
    @HasAuthority(value = {"CREATE"}, inner = true)
    public R<LocalDateTime> hello(
            @RequestHeader(value = AuthConstants.TOKEN_HEADER_NAME, required = false) String token,
            @RequestHeader(required = false) String from
    ) {
        return R.ok(LocalDateTime.now());
    }

}
