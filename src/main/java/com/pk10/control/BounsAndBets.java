package com.pk10.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pk10.bean.LotteryHistory;
import com.pk10.bean.UserInfo;
import com.pk10.service.LotteryHistoryService;
import com.pk10.service.UserInfoService;

/**
 * 下注和获奖相关
 * 
 * @author Administrator
 *
 */
@Controller
public class BounsAndBets {

	private static final Logger logger = LoggerFactory.getLogger(BounsAndBets.class);

	@Autowired
	private LotteryHistoryService lotteryHistoryService;

	@Autowired
	private UserInfoService userInfoService;
	/**
	 * 获取开奖结果
	 * 
	 * @param num
	 *            开奖期数
	 * @return
	 */
	@RequestMapping("getBonusNum")
	@ResponseBody
	public Object getBonusNum(Integer num) {
		try {
			if (num == null) {
				return lotteryHistoryService.getLastLottery();
			} else {
				return lotteryHistoryService.getOneById(new LotteryHistory(num, null, null));
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "{errmsg:" + e.getMessage() + "}";
		}
	}

	/**
	 * 获取开奖记录，
	 * 
	 * @param num
	 *            需要获取的记录条数，如果没有此参数，默认获取20条
	 * @return
	 */
	@RequestMapping("getBonusRecord")
	@ResponseBody
	public Object getLotteryHistory(Integer num) {
		try {
			if (num == null) {
				num = 20;
			}
			return lotteryHistoryService.getLastLottery(num);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "{errmsg:" + e.getMessage() + "}";
		}
	}

	/**
	 * 用户兑奖
	 * 
	 * @param lotteryHistory
	 * @param userInfo
	 * @return
	 */
	public Object cashPrize(@RequestBody LotteryHistory lotteryHistory, @RequestBody UserInfo userInfo) {
		// TODO 用户兑奖操作
		return lotteryHistoryService;
	}
}
