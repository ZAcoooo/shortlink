package io.github.zacoooo.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.zacoooo.shortlink.admin.dao.entity.UserDO;
import io.github.zacoooo.shortlink.admin.dto.resp.UserRespDTO;

/**
 * 用户接口层
 */
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param Username 用户名
     * @return 用户返回实体
     */
    UserRespDTO getUserByUsername(String Username);

    /**
     * 查询用户名是否存在
     *
     * @param username 用户名
     * @return 用户名存在返回 True，不存在返回 False
     */
    Boolean hasUsername(String username);
}
