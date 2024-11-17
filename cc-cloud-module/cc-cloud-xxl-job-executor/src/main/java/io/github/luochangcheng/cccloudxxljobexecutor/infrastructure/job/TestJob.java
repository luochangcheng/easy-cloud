package io.github.luochangcheng.cccloudxxljobexecutor.infrastructure.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class TestJob {

    /**
     * 定时同步-船年卡订单检查
     */
    @XxlJob("testJobHandler")
    public void testJobHandler() {
        log.info("测试开始:{}", LocalDateTime.now());
        log.info("测试结束:{}", LocalDateTime.now());
    }

}
