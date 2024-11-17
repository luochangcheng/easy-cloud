package io.github.luochangcheng.cccloudmonitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class CcCloudMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CcCloudMonitorApplication.class, args);
    }

}
