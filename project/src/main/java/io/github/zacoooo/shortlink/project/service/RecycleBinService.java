package io.github.zacoooo.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.zacoooo.shortlink.project.dao.entity.ShortLinkDO;
import io.github.zacoooo.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import io.github.zacoooo.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import io.github.zacoooo.shortlink.project.dto.req.ShortLinkPageReqDTO;
import io.github.zacoooo.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import io.github.zacoooo.shortlink.project.dto.resp.ShortLinkPageRespDTO;

/**
 * 回收站管理接口层
 */
public interface RecycleBinService extends IService<ShortLinkDO> {

    /**
     * 保存回收站
     *
     * @param requestParam 请求参数
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    /**
     * 分页查询短链接
     *
     * @param requestParam 分页查询短链接请求参数
     * @return 短链接分页返回结果
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam);

    /**
     * 恢复短链接
     *
     * @param requestParam 请求参数
     */
    void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);
}