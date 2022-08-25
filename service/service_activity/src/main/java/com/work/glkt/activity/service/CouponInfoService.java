package com.work.glkt.activity.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.work.glkt.model.activity.CouponInfo;
import com.work.glkt.model.activity.CouponUse;
import com.work.glkt.vo.activity.CouponUseQueryVo;

/**
 * <p>
 * 优惠券信息 服务类
 * </p>
 *
 * @author wzhao
 * @since 2022-08-19
 */
public interface CouponInfoService extends IService<CouponInfo> {

	//获取已经使用优惠券列表（条件查询分页）
	IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam, CouponUseQueryVo couponUseQueryVo);

	//更新优惠券
	void updateCouponInfoUseStatus(Long couponUseId, Long orderId);
}
