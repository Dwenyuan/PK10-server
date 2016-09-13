package com.pk10.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.MoneyAddRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;
import com.pk10.service.UserBetService;

import static com.pk10.util.Const.ERROR_MSG;

@Controller
@RequestMapping("userbet")
public class UserBetControl {
	private static final Logger logger = LoggerFactory.getLogger(UserBetControl.class);

	@Autowired
	private UserBetService userBetService;

	@RequestMapping(value = "createUserBet", method = RequestMethod.POST)
	@ResponseBody
	public Object createUserBet(@RequestBody UserBet userBet) {
		try {
			return userBetService.save(userBet);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping(value = "createUserBets", method = RequestMethod.POST)
	@ResponseBody
	public Object createUserBets(@RequestBody List<UserBet> userBets) {
		try {
			return userBetService.saveList(userBets);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("getUserBetByOpenid")
	@ResponseBody
	public Object getUserBetByOpenid(UserInfo userInfo) {
		try {
			return userBetService.getUserBetByOpenid(userInfo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("getRecentlyBets")
	@ResponseBody
	public Object getRecentlyBets(Integer num) {
		try {
			return userBetService.getRecentlyBets(num);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("/list")
	@ResponseBody
	public String getBetsByUserId(@RequestParam("id")int id) {
		Map<String, Object> map = new HashMap<>();
		List<UserBet> userBets = userBetService.getBetsByUserId(id);
		map.put("userbets", userBets);
		return JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss");
	}

    @RequestMapping(value = "/bets", method = RequestMethod.GET)
    public String getBetList(Model model, @RequestParam(value = "pn", required = false)Integer pn) {
        try {
            if (pn == null || pn <= 0)
                pn = 1;

            PageHelper.startPage(pn, 10);
            List<UserBet> bets =  userBetService.getAll();
            if (bets == null) {
                model.addAttribute(ERROR_MSG, "投注列表为空!");
            } else {
                PageInfo page = new PageInfo(bets);
                if (page.getPageNum() > 0) {
                    model.addAttribute("bets", bets);
                    model.addAttribute("page", page);
                    model.addAttribute("pn", pn);
                }
            }

        } catch (Exception e) {
            model.addAttribute(ERROR_MSG, e.getMessage());
            logger.error(e.getMessage());
        }

        return "admin/bet-list";
    }

	@RequestMapping(value = "/{idnum}", method = RequestMethod.GET)
	public String getBetsByIdnum(Model model, @RequestParam(value = "pn", required = false)Integer pn,
								 @PathVariable("idnum")Integer idnum) {
		try {
			if (pn == null || pn <= 0)
				pn = 1;

			PageHelper.startPage(pn, 10);
			List<UserBet> bets =  userBetService.getBetsByIdnum(idnum);
			if (bets == null) {
				model.addAttribute(ERROR_MSG, "投注列表为空!");
			} else {
				PageInfo page = new PageInfo(bets);
				if (page.getPageNum() > 0) {
					model.addAttribute("bets", bets);
					model.addAttribute("page", page);
					model.addAttribute("pn", pn);
				}
			}

		} catch (Exception e) {
			model.addAttribute(ERROR_MSG, e.getMessage());
			logger.error(e.getMessage());
		}

		return "admin/bet-list";
	}
}
