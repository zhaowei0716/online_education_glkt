package com.work.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author wzhao
 * @create 2022-08-17 20:26
 */
public class ExcelLisener extends AnalysisEventListener<User> {
	@Override
	//按行读取excel中等内容，封装到User中
	//从第二行开始读取
	public void invoke(User user, AnalysisContext analysisContext) {
		System.out.println(user);
	}

	//读取excel表头信息
	@Override
	public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
		System.out.println("表头信息："+headMap);
	}


	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {

	}
}
