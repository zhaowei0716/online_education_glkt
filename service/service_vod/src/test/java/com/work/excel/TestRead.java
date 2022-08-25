package com.work.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @author wzhao
 * @create 2022-08-17 20:30
 */
public class TestRead {
	public static void main(String[] args) throws Exception {
		String fileName = "D:\\online.xlsx";
		// 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
		EasyExcel.read(fileName, User.class, new ExcelLisener()).sheet().doRead();
	}
}
