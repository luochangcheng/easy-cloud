package io.github.luochangcheng.ccclouduser.controller.common;

import io.github.luochangcheng.cccloudstarterfile.resp.FileResp;
import io.github.luochangcheng.cccloudstarterfile.service.IFileService;
import io.github.luochangcheng.cccloudstarterweb.common.exception.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/common/test")
@Tag(name = "公共-测试")
public class TestController {

    @Autowired
    private IFileService fileService;

    @Operation(summary = "查看当前时间")
    @GetMapping("/hello")
    public R<LocalDateTime> hello() {
        return R.ok(LocalDateTime.now());
    }

    @Parameters(value = {
            @Parameter(name = "file", description = "文件")
    })
    @Operation(summary = "上传文件")
    @PostMapping("/upload")
    public Mono<R<FileResp>> upload(@RequestPart FilePart file) {
        return fileService.upload(file)
                .flatMap(resp -> Mono.just(R.ok(resp)));
    }

}
