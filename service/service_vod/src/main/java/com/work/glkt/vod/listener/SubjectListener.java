package com.work.glkt.vod.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.work.glkt.model.vod.Subject;
import com.work.glkt.vo.vod.SubjectEeVo;
import com.work.glkt.vod.mapper.SubjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wzhao
 * @create 2022-08-17 21:03
 */
@Component
public class SubjectListener extends AnalysisEventListener<SubjectEeVo> {

	@Autowired
	private SubjectMapper dictMapper;
	//一行一行读取
	@Override
	public void invoke(SubjectEeVo subjectEeVo, AnalysisContext analysisContext) {
		//调用方法添加数据库
		Subject subject = new Subject();
		BeanUtils.copyProperties(subjectEeVo,subject);
		dictMapper.insert(subject);
	}
	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {
	}
}
