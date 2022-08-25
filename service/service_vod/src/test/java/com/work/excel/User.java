package com.work.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author wzhao
 * @create 2022-08-17 20:16
 */
@Data
public class User {
	//设置表头名称
	@ExcelProperty(value = "用户编号", index = 0)
	private int id;
	//设置表头名称
	@ExcelProperty(value = "用户姓名", index = 1)
	private String name;
}
