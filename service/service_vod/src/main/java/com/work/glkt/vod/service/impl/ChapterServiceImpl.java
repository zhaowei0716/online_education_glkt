package com.work.glkt.vod.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.glkt.model.vod.Chapter;
import com.work.glkt.model.vod.Video;
import com.work.glkt.vo.vod.ChapterVo;
import com.work.glkt.vo.vod.VideoVo;
import com.work.glkt.vod.mapper.ChapterMapper;
import com.work.glkt.vod.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.work.glkt.vod.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author wzhao
 * @since 2022-08-18
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

	@Autowired
	private VideoService videoService;
	@Override
	//1 大纲列表（章节和小节列表）
	public List<ChapterVo> getTreeList(Long courseId) {
		//定义最终数据list集合
		List<ChapterVo> finalChapterList = new ArrayList<>();
		//根据id获取所有章节
		QueryWrapper<Chapter> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("course_id",courseId );
		List<Chapter> chapterList = baseMapper.selectList(queryWrapper);
		//根据id获取小节
		LambdaQueryWrapper<Video> wrapperVideo = new LambdaQueryWrapper<>();
		wrapperVideo.eq(Video::getCourseId,courseId);
		List<Video> videoList = videoService.list(wrapperVideo);
		//封装章节
		for (int i = 0; i < chapterList.size(); i++) {
			Chapter chapter = chapterList.get(i);
			//chapter --> chapterVo
			ChapterVo chapterVo = new ChapterVo();
			BeanUtils.copyProperties(chapter,chapterVo);
			finalChapterList.add(chapterVo);

			//封装小节
			List<VideoVo> videoVoList = new ArrayList<>();
			for(Video video : videoList){
				//判断小节属于哪个章节
				//章节id=小节chapter_id
				if(chapter.getId().equals(video.getChapterId())) {
					// video  -- VideoVo
					VideoVo videoVo = new VideoVo();
					BeanUtils.copyProperties(video,videoVo);
					//放到videoVoList
					videoVoList.add(videoVo);
				}
			}
			//把章节里面所有小节集合放到每个章节里面
			chapterVo.setChildren(videoVoList);
		}
		return finalChapterList;
	}

	@Override
	public void removeChapterByCourseId(Long id) {
		QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
		wrapper.eq("course_id", id);
		baseMapper.delete(wrapper);
	}
}
