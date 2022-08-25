package com.work.glkt.wechat.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.work.glkt.model.wechat.Menu;
import com.work.glkt.vo.wechat.MenuVo;

import java.util.List;

/**
 * <p>
 * 订单明细 订单明细 服务类
 * </p>
 *
 * @author wzhao
 * @since 2022-08-22
 */
public interface MenuService extends IService<Menu> {

	List<MenuVo> findMenuInfo();

	List<Menu> findMenuOneInfo();

	void syncMenu();

	void removeMenu();
}
