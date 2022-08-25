package com.work.glkt.vod.controller;

import com.work.glkt.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wzhao
 * @create 2022-08-14 15:28
 */
@RestController
@RequestMapping("/admin/vod/user")
//@CrossOrigin
public class UserLoginController {

	//login
	@PostMapping("login")
	public Result login(){
		//"token":"admin-token"}
		Map<String , Object> map = new HashMap<>();
		map.put("token","admin-token");
		return Result.ok(map);
	}

	//info
	@GetMapping("info")
	public Result info(){
		//{"code":20000,"data":
		// {"roles":["admin"],
		// "introduction":"I am a super administrator",
		// 头像"avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
		// "name":"Super adminAdmin"}}
		Map<String , Object> map = new HashMap<>();
		map.put("roles","admin");
		map.put("introduction","I am a super administrator");
		map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
		map.put("name","Super adminAdmin");

		return Result.ok(map);
	}
}
