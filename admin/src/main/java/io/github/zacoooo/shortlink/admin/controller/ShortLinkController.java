package io.github.zacoooo.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.zacoooo.shortlink.admin.common.convention.result.Result;
import io.github.zacoooo.shortlink.admin.remote.ShortLinkRemoteService;
import io.github.zacoooo.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import io.github.zacoooo.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import io.github.zacoooo.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import io.github.zacoooo.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短链接后管控制层
 */
@RestController
public class ShortLinkController {

    /**
     * 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    /**
     * 创建短链接
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkRemoteService.createShortLink(requestParam);
    }

    /**
     * 分页查询短链接
     */
    @GetMapping("/api/short-link/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkRemoteService.pageShortLink(requestParam);
    }
}