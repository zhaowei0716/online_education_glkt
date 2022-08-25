package com.work.glkt.live.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.work.glkt.model.live.LiveCourse;
import com.work.glkt.vo.live.LiveCourseVo;

import java.util.List;

/**
 * <p>
 * 直播课程表 Mapper 接口
 * </p>
 *
 * @author wzhao
 * @since 2022-08-24
 */
public interface LiveCourseMapper extends BaseMapper<LiveCourse> {

	List<LiveCourseVo> getLatelyList();
}
