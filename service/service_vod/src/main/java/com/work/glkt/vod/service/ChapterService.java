package com.work.glkt.vod.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.work.glkt.model.vod.Chapter;
import com.work.glkt.vo.vod.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author wzhao
 * @since 2022-08-18
 */
public interface ChapterService extends IService<Chapter> {

	List<ChapterVo> getTreeList(Long courseId);

	void removeChapterByCourseId(Long id);
}
