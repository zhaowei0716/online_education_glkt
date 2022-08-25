package com.work.glkt.vod.service.impl;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.glkt.exception.GlktException;
import com.work.glkt.model.vod.Subject;
import com.work.glkt.result.Result;
import com.work.glkt.vo.vod.SubjectEeVo;
import com.work.glkt.vod.listener.SubjectListener;
import com.work.glkt.vod.mapper.SubjectMapper;
import com.work.glkt.vod.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author wzhao
 * @since 2022-08-17
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

	@Autowired
	private SubjectListener subjectListener;
	@Override
	public List<Subject> selectSubjectList(Long id) {
		//select * from subject where parent_id = 0;
		QueryWrapper<Subject> wrapper = new QueryWrapper<>();
		wrapper.eq("parent_id", id);
		List<Subject> subjectList = baseMapper.selectList(wrapper);
		//遍历subjectList，判断有无下一层数据，如果有，hasChildren=true
		for(Subject s : subjectList){
			Long subjectId = s.getId();
			//查询
			boolean isChild = this.isChildren(subjectId);
			//封装到对象
			s.setHasChildren(isChild);
		}
		return subjectList;
	}

	@Override
	public void exportData(HttpServletResponse response) {
		try {
			//设置下载信息
			response.setContentType("application/vnd.ms-excel");
			response.setCharacterEncoding("utf-8");
			// 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
			String fileName = URLEncoder.encode("课程分类", "UTF-8");
			response.setHeader("Content-disposition", "attachment;filename="+ fileName + ".xlsx");
			//查询表中所有数据
			List<Subject> dictList = baseMapper.selectList(null);
			//List<Subject>  --->  List<SubjectEeVo>
			List<SubjectEeVo> dictVoList = new ArrayList<>(dictList.size());
			for(Subject dict : dictList) {
				SubjectEeVo dictVo = new SubjectEeVo();
				BeanUtils.copyProperties(dict,dictVo);
				dictVoList.add(dictVo);
			}
			EasyExcel.write(response.getOutputStream(), SubjectEeVo.class)
							.sheet("课程分类")
							.doWrite(dictVoList);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	//判断下一层是否有数据
	private boolean isChildren(Long subjectId) {
		QueryWrapper<Subject> wrapper = new QueryWrapper<>();
		wrapper.eq("parent_id",subjectId );
		Integer count = Math.toIntExact(baseMapper.selectCount(wrapper));
		return count > 0;
	}

	@Override
	public void importDictData(MultipartFile file) {
		try {
			EasyExcel.read(file.getInputStream(),SubjectEeVo.class,subjectListener)
							.sheet().doRead();
		} catch (IOException e) {
			throw new GlktException(20001,"导入失败");
		}
	}


}
