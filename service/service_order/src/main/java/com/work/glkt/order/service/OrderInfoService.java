package com.work.glkt.order.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.work.glkt.model.order.OrderInfo;
import com.work.glkt.vo.order.OrderFormVo;
import com.work.glkt.vo.order.OrderInfoQueryVo;
import com.work.glkt.vo.order.OrderInfoVo;

import java.util.Map;

/**
 * <p>
 * 订单表 订单表 服务类
 * </p>
 *
 * @author wzhao
 * @since 2022-08-19
 */
public interface OrderInfoService extends IService<OrderInfo> {

	Map<String,Object> selectOrderInfoPage(Page<OrderInfo> pageParam, OrderInfoQueryVo orderInfoQueryVo);

	Long submitOrder(OrderFormVo orderFormVo);

	OrderInfoVo getOrderInfoById(Long id);

	void updateOrderStatus(String out_trade_no);
}
