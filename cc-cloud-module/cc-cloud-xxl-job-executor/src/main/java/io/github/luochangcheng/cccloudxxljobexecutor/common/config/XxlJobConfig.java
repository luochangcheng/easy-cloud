package io.github.luochangcheng.cccloudxxljobexecutor.common.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Slf4j
@Configuration
public class XxlJobConfig {

    @Value("${cc-cloud.xxl-job.addresses}")
    private String adminAddresses;

    @Value("${cc-cloud.xxl-job.access-token}")
    private String accessToken;

    @Value("${cc-cloud.xxl-job.executor.app-name}")
    private String appName;

    @Value("${cc-cloud.xxl-job.executor.ip}")
    private String ip;

    @Value("${cc-cloud.xxl-job.executor.port}")
    private int port;

    @Value("${cc-cloud.xxl-job.executor.log-path}")
    private String logPath;

    @Value("${cc-cloud.xxl-job.executor.log-retention-days}")
    private int logRetentionDays;

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job register:{}", LocalDateTime.now());
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appName);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);
        return xxlJobSpringExecutor;
    }

}

