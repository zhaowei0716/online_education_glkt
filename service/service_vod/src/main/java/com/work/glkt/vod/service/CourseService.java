package com.work.glkt.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.work.glkt.model.vod.Course;
import com.work.glkt.vo.vod.CourseFormVo;
import com.work.glkt.vo.vod.CoursePublishVo;
import com.work.glkt.vo.vod.CourseQueryVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author wzhao
 * @since 2022-08-18
 */
public interface CourseService extends IService<Course> {

	Map<String, Object> findPageCourse(Page<Course> pageParam, CourseQueryVo courseQueryVo);

	Long saveCourseInfo(CourseFormVo courseFormVo);

	CourseFormVo getCourseInfoById(Long id);

	void updateCourseId(CourseFormVo courseFormVo);

	CoursePublishVo getCoursePublishVo(Long id);

	void publishCourse(Long id);

	void removeCourseId(Long id);

	Map<String,Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo);

	Map<String,Object> getInfoById(Long courseId);
}
