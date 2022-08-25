package com.work.glkt.vod.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.work.glkt.model.vod.Subject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author wzhao
 * @since 2022-08-17
 */
public interface SubjectService extends IService<Subject> {

	List<Subject> selectSubjectList(Long id);


	void exportData(HttpServletResponse response);

	void importDictData(MultipartFile file);
}
