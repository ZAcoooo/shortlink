package io.github.zacoooo.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.zacoooo.shortlink.admin.common.convention.result.Result;
import io.github.zacoooo.shortlink.admin.common.convention.result.Results;
import io.github.zacoooo.shortlink.admin.dto.req.RecycleBinRecoverReqDTO;
import io.github.zacoooo.shortlink.admin.dto.req.RecycleBinRemoveReqDTO;
import io.github.zacoooo.shortlink.admin.dto.req.RecycleBinSaveReqDTO;
import io.github.zacoooo.shortlink.admin.remote.ShortLinkRemoteService;
import io.github.zacoooo.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import io.github.zacoooo.shortlink.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import io.github.zacoooo.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import io.github.zacoooo.shortlink.admin.service.RecycleBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回收站管理控制层
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {

    private final RecycleBinService recycleBinService;

    /**
     * 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    /**
     * 保存回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        shortLinkRemoteService.saveRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 分页查询回收站短链接
     */
    @GetMapping("/api/short-link/admin/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        return recycleBinService.pageRecycleBinShortLink(requestParam);
    }

    /**
     * 恢复短链接
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        shortLinkRemoteService.recoverRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 移除短链接
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/remove")
    public Result<Void> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        shortLinkRemoteService.removeRecycleBin(requestParam);
        return Results.success();
    }
}