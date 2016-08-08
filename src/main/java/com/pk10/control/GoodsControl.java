package com.pk10.control;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pk10.bean.Goods;
import com.pk10.service.GoodsService;
import com.pk10.util.ConverBase64ToImg;

@Controller
public class GoodsControl {

	private static final Logger logger = LoggerFactory.getLogger(GoodsControl.class);

	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "saveGoods", method = RequestMethod.POST)
	@ResponseBody
	public Object saveGoods(@RequestBody Goods goods,HttpServletRequest request) {
		
		// TODO 解码图片并保存
		try {
			String conver = ConverBase64ToImg.conver(request, goods.getGoodsimg());
			goods.setGoodsimg(conver);
			return goodsService.save(goods);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "{errmsg:" + e.getMessage() + "}";
		}
	}

	@RequestMapping("getAllGoods")
	@ResponseBody
	public Object getAllGoods() {
		try {
			return goodsService.getAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "{errmsg:" + e.getMessage() + "}";
		}
	}
}
