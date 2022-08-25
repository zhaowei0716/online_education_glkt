package com.work.glkt.exception;

import com.work.glkt.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wzhao
 * @create 2022-08-12 9:53
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	//全局异常处理
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result error(Exception e){
		e.printStackTrace();
		return Result.fail(null).message("执行全局异常处理");
	}

	//特定异常处理
	@ExceptionHandler(ArithmeticException.class)
	@ResponseBody
	public Result error(ArithmeticException e){
		e.printStackTrace();
		return Result.fail(null).message("执行ArithmeticException异常处理");
	}

	//自定义异常处理
	@ExceptionHandler(GlktException.class)
	@ResponseBody
	public Result error(GlktException e){
		e.printStackTrace();
		return Result.fail(null).code(e.getCode()).message(e.getMsg());
	}
}
