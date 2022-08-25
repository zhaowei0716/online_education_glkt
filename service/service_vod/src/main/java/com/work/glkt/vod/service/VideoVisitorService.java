package com.work.glkt.vod.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.work.glkt.model.vod.VideoVisitor;

import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 服务类
 * </p>
 *
 * @author wzhao
 * @since 2022-08-18
 */
public interface VideoVisitorService extends IService<VideoVisitor> {


	Map<String,Object> findCount(Long courseId, String startDate, String endDate);
}
