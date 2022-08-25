package com.work.glkt.vod.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.work.glkt.model.vod.Course;
import com.work.glkt.vo.vod.CoursePublishVo;
import com.work.glkt.vo.vod.CourseVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author wzhao
 * @since 2022-08-18
 */
public interface CourseMapper extends BaseMapper<Course> {

	//根据课程id查询发布课程信息
	CoursePublishVo selectCoursePublishVoById(Long id);

	//根据课程id查询课程详情
	CourseVo selectCourseVoById(Long courseId);
}
