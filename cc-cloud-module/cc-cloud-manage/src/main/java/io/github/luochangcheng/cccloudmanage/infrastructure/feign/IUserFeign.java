package io.github.luochangcheng.cccloudmanage.infrastructure.feign;

import io.github.luochangcheng.cccloudmanage.infrastructure.feign.fallback.UserFeignFallback;
import io.github.luochangcheng.cccloudstarterweb.common.exception.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@FeignClient(name = "user", fallback = UserFeignFallback.class)
public interface IUserFeign {

    @GetMapping("/common/test/hello")
    R<LocalDateTime> hello();

}
