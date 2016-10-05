package com.pk10.control;

import com.pk10.bean.Datagrid;
import com.pk10.bean.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.LotteryHistory;
import com.pk10.service.LotteryHistoryService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.List;

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
			JSON.parse("{errmsg:" + e.getMessage() + "}");
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	/**
	 * 根据id列表批量获取 获取开奖结果
	 * 
	 * @param num
	 *            开奖期数
	 * @return
	 */
	@RequestMapping(value = "getBonusNums", method = RequestMethod.POST)
	@ResponseBody
	public Object getBonusNums(@RequestBody ArrayList<Integer> nums) {
		try {
			if (nums == null) {
				return lotteryHistoryService.getLastLottery();
			} else if (nums.size() == 0) {
				return new ArrayList<LotteryHistory>();
			} else {
				return lotteryHistoryService.getNumsById(nums);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			JSON.parse("{errmsg:" + e.getMessage() + "}");
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
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
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	/**
	 * 开奖管理
	 */
	@RequestMapping("toLotteryHistory")

	public Object toLotteryHistory(Model model, Page page) {
		try {
			if (page.getPages() == 0) {
				page.setPages(1);
				Datagrid datagrid = lotteryHistoryService.getAllInPage(page);
				model.addAttribute("lhData", datagrid);
				return "admin/lotteryhistory";
			} else {
				Datagrid datagrid = lotteryHistoryService.getAllInPage(page);
				model.addAttribute("lhData", datagrid);
				return "admin/lotteryhistory";
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("getRecordById")
	@ResponseBody
	public Object getRecordById(@RequestBody LotteryHistory lotteryHistory) {
		try {
			return JSON.toJSONString(lotteryHistoryService.getHistoryById(lotteryHistory));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

}
