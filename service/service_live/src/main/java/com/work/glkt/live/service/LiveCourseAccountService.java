package com.work.glkt.live.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.work.glkt.model.live.LiveCourseAccount;

/**
 * <p>
 * 直播课程账号表（受保护信息） 服务类
 * </p>
 *
 * @author atguigu
 * @since 2022-05-09
 */
public interface LiveCourseAccountService extends IService<LiveCourseAccount> {

    //获取直播账号信息
    LiveCourseAccount getLiveCourseAccountCourseId(Long id);
}
