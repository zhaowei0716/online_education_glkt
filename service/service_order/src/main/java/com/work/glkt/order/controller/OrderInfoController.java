package com.work.glkt.order.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.work.glkt.model.order.OrderInfo;
import com.work.glkt.order.service.OrderInfoService;
import com.work.glkt.result.Result;
import com.work.glkt.vo.order.OrderInfoQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 订单表 订单表 前端控制器
 * </p>
 *
 * @author wzhao
 * @since 2022-08-19
 */
@RestController
@RequestMapping("/admin/order/orderInfo")
public class OrderInfoController {
	@Autowired
	private OrderInfoService orderInfoService;

	//订单列表
	@GetMapping("{page}/{limit}")
	public Result listOrder(@PathVariable Long page,
							@PathVariable Long limit,
							OrderInfoQueryVo orderInfoQueryVo){
		Page<OrderInfo> pageParam = new Page<>();
		Map<String,Object> map =orderInfoService.selectOrderInfoPage(pageParam,orderInfoQueryVo);
		return Result.ok(map);
	}
}

