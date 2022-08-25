package com.work.glkt.vod.service;

import org.springframework.web.multipart.MultipartFile; /**
 * @author wzhao
 * @create 2022-08-17 16:23
 */
public interface FileService {
	String upload(MultipartFile file);
}
