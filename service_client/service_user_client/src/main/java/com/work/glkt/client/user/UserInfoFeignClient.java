package com.work.glkt.client.user;

import com.work.glkt.model.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wzhao
 * @create 2022-08-22 10:53
 */
@FeignClient(value = "service-user")
public interface UserInfoFeignClient {

	@GetMapping("/admin/user/userInfo/inner/getById/{id}")
	public UserInfo getById(@PathVariable(value = "id") Long id);
}
