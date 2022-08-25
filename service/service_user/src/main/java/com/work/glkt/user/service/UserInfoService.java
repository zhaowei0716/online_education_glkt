package com.work.glkt.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.work.glkt.model.user.UserInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2022-04-29
 */
public interface UserInfoService extends IService<UserInfo> {

    //openid查询
    UserInfo getUserInfoOpenid(String openId);
}
