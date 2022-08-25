package com.work.glkt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wzhao
 * @create 2022-08-12 10:06
 */
@Data
//有参和无参构造
@AllArgsConstructor
@NoArgsConstructor
public class GlktException extends RuntimeException {
	private  Integer code;
	private String msg;

}
