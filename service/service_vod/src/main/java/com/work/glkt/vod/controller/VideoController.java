package com.work.glkt.vod.controller;


import com.work.glkt.model.vod.Video;
import com.work.glkt.result.Result;
import com.work.glkt.vod.service.VideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author wzhao
 * @since 2022-08-18
 */
@RestController
@RequestMapping("/admin/vod/video")
//@CrossOrigin
public class VideoController {
	@Autowired
	private VideoService videoService;

	@ApiOperation(value = "获取")
	@GetMapping("get/{id}")
	public Result get(@PathVariable Long id) {
		Video video = videoService.getById(id);
		return Result.ok(video);
	}

	@ApiOperation(value = "新增")
	@PostMapping("save")
	public Result save(@RequestBody Video video) {
		videoService.save(video);
		return Result.ok(null);
	}

	@ApiOperation(value = "修改")
	@PutMapping("update")
	public Result updateById(@RequestBody Video video) {
		videoService.updateById(video);
		return Result.ok(null);
	}

	@ApiOperation(value = "删除")
	@DeleteMapping("remove/{id}")
	public Result remove(@PathVariable Long id) {
		videoService.removeVideoById(id);
		return Result.ok(null);
	}
}

