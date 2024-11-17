package io.github.luochangcheng.ccclouduser.controller.common;

import io.github.luochangcheng.cccloudstartermybatisplus.utils.page.PageReq;
import io.github.luochangcheng.cccloudstartermybatisplus.utils.page.PageResp;
import io.github.luochangcheng.cccloudstarterweb.common.exception.R;
import io.github.luochangcheng.ccclouduser.http.req.common.SysDictModifyReq;
import io.github.luochangcheng.ccclouduser.http.req.common.SysDictReq;
import io.github.luochangcheng.ccclouduser.http.resp.common.SysDictResp;
import io.github.luochangcheng.ccclouduser.service.ISysDictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 字典 前端控制器
 * </p>
 *
 * @author passion
 * @since 2024-11-13 11:54:46
 */
@Tag(name = "公共资源端-字典")
@RestController
@RequestMapping("/common/sys-dict")
public class SysDictController {

    @Autowired
    private ISysDictService service;

    @Operation(summary = "获取字典明细")
    @Parameter(name = "id", description = "字典主键")
    @GetMapping("/detail/{id}")
    public R<SysDictResp> getDetail(
            @PathVariable("id") String id
    ) {
        return R.ok(service.getDetail(id));
    }

    @Operation(summary = "获取字典分页")
    @PostMapping("/list")
    public R<PageResp<SysDictResp>> getPage(
            @RequestBody @Validated PageReq<SysDictReq> req
    ) {
        return R.ok(service.getPage(req));
    }

    @Operation(summary = "新增字典")
    @PostMapping("/create")
    public R<String> create(
            @RequestBody SysDictModifyReq req
    ) {
        return R.ok(service.create(req));
    }

    @Operation(summary = "修改字典")
    @PutMapping("/modify")
    public R<String> modify(
            @RequestBody SysDictModifyReq req
    ) {
        return R.ok(service.modify(req));
    }

    @Operation(summary = "删除字典")
    @Parameter(name = "id", description = "字典主键")
    @DeleteMapping("/delete")
    public R<Boolean> delete(
            @RequestParam("id") List<Long> id
    ) {
        return R.ok(service.delete(id));
    }

}
