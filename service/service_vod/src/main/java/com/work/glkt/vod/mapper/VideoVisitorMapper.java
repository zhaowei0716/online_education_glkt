package com.work.glkt.vod.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.work.glkt.model.vod.VideoVisitor;
import com.work.glkt.vo.vod.VideoVisitorCountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 视频来访者记录表 Mapper 接口
 * </p>
 *
 * @author wzhao
 * @since 2022-08-18
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {

	List<VideoVisitorCountVo> findCount(@Param("courseId") Long courseId,
										@Param("startDate") String startDate,
										@Param("endDate") String endDate);
}
