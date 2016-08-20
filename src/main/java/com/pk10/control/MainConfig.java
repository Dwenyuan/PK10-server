package com.pk10.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.TokenConfig;
import com.pk10.service.LotteryHistoryService;
import com.pk10.util.CreateBonus;
import com.pk10.util.WeChatSign;

@Controller
public class MainConfig {
	private static final Logger logger = LoggerFactory.getLogger(MainConfig.class);

	@Autowired
	private TokenConfig tokenConfig;

	@Autowired
	private CreateBonus createBonus;

	@Autowired
	private LotteryHistoryService lotteryHistoryService;

	@RequestMapping("checkToken")
	public void checkToken(String echostr, HttpServletResponse response) {
		try {
			response.getWriter().write(echostr);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 获取注册参数 主要包括 <br>
	 * appId: <br>
	 * timestamp: <br>
	 * nonceStr: <br>
	 * signature: <br>
	 * 
	 * @return
	 */
	@RequestMapping("getMainConfig")
	@ResponseBody
	public Object getMainConfig(@Param(value = "url") String url) {
		return tokenConfig;
	}

	/**
	 * 获取计时器 倒计时秒数
	 * 
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("getCount")
	@ResponseBody
	public Object getCount() {
		Integer idnum = null;
		try {
			Integer id = lotteryHistoryService.getLastLottery().getId();
			idnum = id; // 当前开奖期数
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return JSON.parse("{\"idnum\":" + idnum + ",\"countDown\":" + createBonus.getCount() + ",\"countNum\":" + createBonus.getCountNum() + "}");
	}

	@RequestMapping("getSign")
	@ResponseBody
	public Object getSign(HttpServletRequest request) {
		String jsapi_ticket = "jsapi_ticket";
		String url = request.getRequestURL().toString();
		return WeChatSign.sign(jsapi_ticket, url);
	}
}
