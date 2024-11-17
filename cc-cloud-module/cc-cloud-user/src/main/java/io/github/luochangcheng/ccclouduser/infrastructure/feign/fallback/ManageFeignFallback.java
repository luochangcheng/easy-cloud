package io.github.luochangcheng.ccclouduser.infrastructure.feign.fallback;

import io.github.luochangcheng.cccloudstarterweb.common.exception.R;
import io.github.luochangcheng.ccclouduser.infrastructure.feign.IManageFeign;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ManageFeignFallback implements IManageFeign {

    @Override
    public R<LocalDateTime> hello() {
        return R.failed();
    }

}
