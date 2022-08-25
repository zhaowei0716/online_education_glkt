package com.work.glkt.vod.service;

import java.util.Map;

/**
 * @author wzhao
 * @create 2022-08-18 19:48
 */
public interface VodService {
	String updateVideo();

	void removeVideo(String fileId);

	//点播视频播放接口
	Map<String, Object> getPlayAuth(Long courseId, Long videoId);

}
