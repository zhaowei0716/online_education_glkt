package com.work.glkt.live.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.work.glkt.live.mapper.LiveCourseConfigMapper;
import com.work.glkt.live.service.LiveCourseConfigService;
import com.work.glkt.model.live.LiveCourseConfig;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 直播课程配置表 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-05-09
 */
@Service
public class LiveCourseConfigServiceImpl extends ServiceImpl<LiveCourseConfigMapper, LiveCourseConfig> implements LiveCourseConfigService {

    //根据课程id查询配置信息
    @Override
    public LiveCourseConfig getCourseConfigCourseId(Long liveCourseId) {
        return baseMapper.selectOne(new LambdaQueryWrapper<LiveCourseConfig>().eq(
                LiveCourseConfig::getLiveCourseId,
                liveCourseId));
    }
}
