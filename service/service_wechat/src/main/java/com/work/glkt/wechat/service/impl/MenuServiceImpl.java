package com.work.glkt.wechat.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.glkt.exception.GlktException;
import com.work.glkt.model.wechat.Menu;
import com.work.glkt.vo.wechat.MenuVo;
import com.work.glkt.wechat.mapper.MenuMapper;
import com.work.glkt.wechat.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单明细 订单明细 服务实现类
 * </p>
 *
 * @author wzhao
 * @since 2022-08-22
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
	@Autowired
	private WxMpService wxMpService;

	//获取全部菜单
	@Override
	public List<MenuVo> findMenuInfo() {
		//1.创建list集合，用户最终数据封装
		List<MenuVo> finalMenuList = new ArrayList<>();

		//2.查询所有菜单数据（包含一级二级）
		List<Menu> menuList = baseMapper.selectList(null);

		//3.从所有菜单数据获取所有一级菜单数据（parent_id = 0)
		//4.封装一级菜单数据到List集合中
		List<Menu> oneMenuList = menuList.stream().filter(menu ->
				menu.getParentId().longValue() == 0).collect(Collectors.toList());

		//遍历一级菜单的集合，做类型转换
		for(Menu oneMenu : oneMenuList) {
			MenuVo oneMenuVo = new MenuVo();
			BeanUtils.copyProperties(oneMenu, oneMenuVo);
			//5.封装二级菜单数据（判断一级菜单和二级菜单parent_id是否相同）
			List<Menu> twoMenuList = menuList.stream()
					.filter(menu -> menu.getParentId().longValue() == oneMenu.getId())
					.sorted(Comparator.comparing(Menu::getSort))
					.collect(Collectors.toList());
			List<MenuVo> children = new ArrayList<>();
			//类型转换
			for(Menu twoMenu : twoMenuList) {
				MenuVo twoMenuVo = new MenuVo();
				BeanUtils.copyProperties(twoMenu, twoMenuVo);
				children.add(twoMenuVo);
			}
			//把二级菜单数据放进一级菜单
			oneMenuVo.setChildren(children);
			finalMenuList.add(oneMenuVo);
		}
		return finalMenuList;
	}

	@Override
	public List<Menu> findMenuOneInfo() {
		QueryWrapper<Menu> wrapper = new QueryWrapper<>();
		wrapper.eq("parent_id",0);
		List<Menu> list = baseMapper.selectList(wrapper);
		return list;
	}

	//同步菜单
	@Override
	public void syncMenu() {
		List<MenuVo> menuVoList = this.findMenuInfo();
		//封装botton里面结构，数组格式
		//一级
		JSONArray buttonList = new JSONArray();
		for(MenuVo oneMenuVo : menuVoList) {
			JSONObject one = new JSONObject();
			one.put("name", oneMenuVo.getName());
			//二级
			JSONArray subButton = new JSONArray();
			for(MenuVo twoMenuVo : oneMenuVo.getChildren()) {
				JSONObject view = new JSONObject();
				view.put("type", twoMenuVo.getType());
				if(twoMenuVo.getType().equals("view")) {
					view.put("name", twoMenuVo.getName());
					view.put("url", "http://weixin.5gzvip.91tunnel.com/#"
							+twoMenuVo.getUrl());
				} else {
					view.put("name", twoMenuVo.getName());
					view.put("key", twoMenuVo.getMeunKey());
				}
				subButton.add(view);
			}
			one.put("sub_button", subButton);
			buttonList.add(one);
		}
		//封装最外层数据
		JSONObject button = new JSONObject();
		button.put("button", buttonList);
		//把数据结构进行实现与封装
		try {
			String menuId = this.wxMpService.getMenuService().menuCreate(button.toJSONString());
			System.out.println("menuId:" + menuId);
		} catch (WxErrorException e) {
			e.printStackTrace();
			throw new GlktException(20001,"公众号菜单同步失败");
		}
	}

	//删除菜单
	@Override
	public void removeMenu() {
		try {
			wxMpService.getMenuService().menuDelete();
		} catch (WxErrorException e) {
			e.printStackTrace();
			throw new GlktException(20001,"公众号菜单删除失败");
		}
	}
	/**
	 * {
	 "button":[
	 {
	 "type":"click",
	 "name":"今日歌曲",
	 "key":"V1001_TODAY_MUSIC"
	 },
	 {
	 "name":"菜单",
	 "sub_button":[
	 {
	 "type":"view",
	 "name":"搜索",
	 "url":"http://www.soso.com/"
	 },
	 {
	 "type":"miniprogram",
	 "name":"wxa",
	 "url":"http://mp.weixin.qq.com",
	 "appid":"wx286b93c14bbf93aa",
	 "pagepath":"pages/lunar/index"
	 },
	 {
	 "type":"click",
	 "name":"赞一下我们",
	 "key":"V1001_GOOD"
	 }]
	 }]
	 }
	 */
}
