package com.work.glkt.live.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.work.glkt.model.live.LiveCourseConfig;

/**
 * <p>
 * 直播课程配置表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2022-05-09
 */
public interface LiveCourseConfigService extends IService<LiveCourseConfig> {

    //根据课程id查询配置信息
    LiveCourseConfig getCourseConfigCourseId(Long id);
}
