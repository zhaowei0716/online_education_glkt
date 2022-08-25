package com.work.glkt.vod.controller;


import com.work.glkt.model.vod.Subject;
import com.work.glkt.result.Result;
import com.work.glkt.vod.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author wzhao
 * @since 2022-08-17
 */
@RestController
@RequestMapping(value="/admin/vod/subject")
//@CrossOrigin
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	//课程分类加载
	@ApiOperation("课程分类列表")
	@GetMapping("getChildSubject/{id}")
	public Result getChildSubject(@PathVariable Long id){
		List<Subject> list = subjectService.selectSubjectList(id);
		return Result.ok(list);
	}

	//课程分类导出
	@ApiOperation("课程分类导出")
	@GetMapping("exportData")
	public void exportData(HttpServletResponse response){
		subjectService.exportData(response);
	}

	//课程分类导入
	@ApiOperation(value = "导入")
	@PostMapping("importData")
	public Result importData(MultipartFile file) {
		subjectService.importDictData(file);
		return Result.ok(null);
	}

}

