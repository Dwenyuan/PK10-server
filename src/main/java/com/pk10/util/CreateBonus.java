package com.pk10.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pk10.bean.TokenConfig;
import com.pk10.bean.TokenInfo;
import com.pk10.service.TokenConfigService;
import com.pk10.service.TokenInfoService;
import com.sina.sae.fetchurl.SaeFetchurl;

/**
 * 自动生成中奖码以及倒计时
 * 
 * @author Administrator
 *
 */
public class CreateBonus implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(CreateBonus.class);

	private static Integer count; // 倒计时

	private static String idnum;
	private static Integer countNum;

	@Autowired
	private TokenConfig tokenConfig;

	@Autowired
	private TokenConfigService tokenConfigService;

	@Autowired
	private TokenInfoService tokenInfoService;

	public static String getIdnum() {
		return idnum;
	}

	public static void setIdnum(String idnum) {
		CreateBonus.idnum = idnum;
	}

	public static Integer getCountNum() {
		return countNum;
	}

	public static void setCountNum(Integer countNum) {
		CreateBonus.countNum = countNum;
	}

	public static Integer getCount() {
		return count;
	}

	public static void setCount(Integer count) {
		CreateBonus.count = count;
	}

	public CreateBonus() {
		super();
	}

	public void run() {
		countNum = tokenConfig.getLotteryTime();
		getCount(new Date());
		// logger.info("执行倒计时任务，当前count ==" + count);
	}

	/**
	 * 距离当前最近的开奖时间的倒计时
	 * 
	 * @param date
	 *            当前时间
	 * @return
	 */
	public static void getCount(Date date) {
		Integer hour = Integer.parseInt(new SimpleDateFormat("HH").format(date));
		Integer min = Integer.parseInt(new SimpleDateFormat("mm").format(date));
		Integer sec = Integer.parseInt(new SimpleDateFormat("ss").format(date));
		if (hour >= 0 && hour < 9) {// 不在开奖时间
			count = (9 * 60 * 60 + 7 * 60) - (hour * 60 * 60 + min * 60 + sec);
		} else { // 寻找最近的开奖时间
			if (min % 10 < 2) {// 否则为逢2
				count = (1 - (min % 10)) * 60 + (60 - sec);
			} else if (min % 10 < 7 && min % 10 >= 2) { // 在2和7之间，则下次开奖为逢7
				count = (6 - (min % 10)) * 60 + (60 - sec);
			} else { // 否则为逢2
				count = (11 - (min % 10)) * 60 + (60 - sec);
			}
		}
	}

	/**
	 * 每隔2个小时获取一次全局的token票据 并存储起来
	 * 
	 * @throws Exception
	 */
	public void getTokenAccess() throws Exception {
		TokenConfig safeTokenConfig = tokenConfigService.getLastTokenConfig();
		logger.info("start task get access-token ....");
		String accessToken = new SaeFetchurl()
				.fetch("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + safeTokenConfig.getAppID() + "&secret=" + safeTokenConfig.getAppsecret());
		JSONObject message = JSON.parseObject(accessToken);
		if (message != null && message.getString("access_token") != null) { // 如果获取的内容都不为空则保存起来
			String jsapiTicket = this.getJsapiTicket(message.getString("access_token"));
			Integer save = tokenInfoService.save(new TokenInfo(message.getString("access_token"),jsapiTicket, new Date(), new Date()));
		} else {
			throw new Exception("access_token get has a error");
		}
	}

	public String getJsapiTicket(String tokenAccess) throws Exception {
		String jsapiToken = new SaeFetchurl().fetch("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + tokenAccess + "&type=jsapi");
		JSONObject jsapi = JSON.parseObject(jsapiToken);
		if (jsapi != null && jsapi.getString("ticket") != null) {
			return jsapi.getString("ticket");
		} else {
			throw new Exception("get jsapi ticket has a error");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// 储存全局票据
		Integer update = tokenConfigService.update(tokenConfig);
		if (update < 1) {
			tokenConfigService.save(tokenConfig);
		}
	}
}
