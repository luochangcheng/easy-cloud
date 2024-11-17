package io.github.luochangcheng.ccclouduser.infrastructure.feign;

import io.github.luochangcheng.cccloudstarterweb.common.exception.R;
import io.github.luochangcheng.ccclouduser.infrastructure.feign.fallback.ManageFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@FeignClient(name = "manage", fallback = ManageFeignFallback.class)
public interface IManageFeign {

    @GetMapping("/common/test/hello")
    R<LocalDateTime> hello();

}
