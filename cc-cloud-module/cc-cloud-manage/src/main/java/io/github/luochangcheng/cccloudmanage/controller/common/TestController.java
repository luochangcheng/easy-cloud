package io.github.luochangcheng.cccloudmanage.controller.common;

import io.github.luochangcheng.cccloudmanage.infrastructure.feign.IUserFeign;
import io.github.luochangcheng.cccloudstarterredis.utils.RedisUtil;
import io.github.luochangcheng.cccloudstarterredisson.common.annotation.DistributedLock;
import io.github.luochangcheng.cccloudstarterweb.common.exception.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/common/test")
@Tag(name = "公共-测试")
public class TestController {

    @Autowired
    private RedisUtil<Long> redisUtil;
    @Autowired
    private IUserFeign userFeign;
    @Resource(name = "feignExecutor")
    private Executor executor;

    @Operation(summary = "查看当前时间")
    @GetMapping("/hello")
    public R<LocalDateTime> hello() {
        return R.ok(LocalDateTime.now());
    }

    @Operation(summary = "redis")
    @GetMapping("/redis")
    public R<Long> redis() {
        redisUtil.set("test", 123456789L, Duration.ofSeconds(60));
        return R.ok(redisUtil.get("test"));
    }

    @Parameters(value = {
            @Parameter(name = "key", description = "加锁key")
    })
    @Operation(summary = "分布式锁")
    @DistributedLock(key = "'io.github.luochangcheng.cccloudadmin.controller.common.TestController.lock[key='+#key+']'", releaseTime = 30, waitTime = 5)
    @GetMapping("/lock")
    public R<String> lock(@RequestParam String key) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        return R.ok("getLock");
    }

    @Operation(summary = "feign")
    @GetMapping("/feign")
    public R<LocalDateTime> feign() {
        CompletableFuture<R<LocalDateTime>> async = CompletableFuture.supplyAsync(() -> userFeign.hello(), executor);
        R<LocalDateTime> join = async.join();
        return R.ok(join.getData());
    }

}
