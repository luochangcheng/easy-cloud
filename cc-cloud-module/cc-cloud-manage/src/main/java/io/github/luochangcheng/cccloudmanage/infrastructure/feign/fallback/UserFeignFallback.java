package io.github.luochangcheng.cccloudmanage.infrastructure.feign.fallback;

import io.github.luochangcheng.cccloudmanage.infrastructure.feign.IUserFeign;
import io.github.luochangcheng.cccloudstarterweb.common.exception.R;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserFeignFallback implements IUserFeign {

    @Override
    public R<LocalDateTime> hello() {
        return R.failed();
    }

}
