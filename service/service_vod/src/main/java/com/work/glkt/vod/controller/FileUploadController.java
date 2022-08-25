package com.work.glkt.vod.controller;

import com.work.glkt.result.Result;
import com.work.glkt.vod.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wzhao
 * @create 2022-08-17 16:21
 */
@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/admin/vod/file")
//@CrossOrigin
public class FileUploadController {

	@Autowired
	private FileService fileService;
	/**
	 * 文件上传
	 */
	@ApiOperation(value = "文件上传")
	@PostMapping("upload")
	public Result uploadFile(MultipartFile file) {
		String url = fileService.upload(file);
		return Result.ok(url).message("上传文件成功");
	}
}
