package com.pk10.control;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.GivenMoneyRecord;
import com.pk10.bean.UserInfo;
import com.pk10.service.GivenMoneyRecordService;
import com.pk10.service.UserInfoService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.pk10.util.Const.ERROR_MSG;

/**
 * Created by dengfengdecao on 16/9/24.
 */
@SessionAttributes({"captcha", "userinfo"})
@Controller
@Scope("prototype")
public class GivenMoneyRecordController {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private GivenMoneyRecordService givenMoneyRecordService;

    // 当前用户赠送金币给对方用户
    @RequestMapping(value = "given-money", method = RequestMethod.POST)
    public synchronized String givenMoney(ModelMap map, GivenMoneyRecord givenMoneyRecord, String code) throws Exception {
        if (map.get("captcha").equals(code)) {
            UserInfo currentUser = userInfoService.getUserInfoByUsername(new UserInfo(givenMoneyRecord.getCurrentUsername(), null));
            UserInfo opposingUser = userInfoService.getUserInfoByUsername(new UserInfo(givenMoneyRecord.getOpposingUsername(), null));
            // 赠送的金额大于当前用户的余额
            if (currentUser.getMoney() < givenMoneyRecord.getGivenMoney()) {
                map.addAttribute("error_response", "赠送的金额大于您当前的余额");
            } else {
                currentUser.setMoney(currentUser.getMoney() - givenMoneyRecord.getGivenMoney());
                opposingUser.setMoney(opposingUser.getMoney() + givenMoneyRecord.getGivenMoney());
                userInfoService.save(currentUser);
                userInfoService.save(opposingUser);

                givenMoneyRecord.setCurrentMoney(currentUser.getMoney());
                givenMoneyRecord.setOpposingMoney(opposingUser.getMoney());
                givenMoneyRecord.setTime(new Date());
                givenMoneyRecordService.save(givenMoneyRecord);

                map.put("userinfo", currentUser);
                map.put("captcha", "");
                map.addAttribute("success_response", "赠送成功!");
            }
        } else {
            map.addAttribute("error_response", "验证码失效");
        }

        return "admin/response";
    }

    @RequestMapping(value = "/given-money-list/{startTime}/{endTime}", method = RequestMethod.GET)
    public String giveMoneyList(Model model, @RequestParam(value = "pn", required = false) Integer pn,
                                @PathVariable("startTime") String startTime,
                                @PathVariable("endTime")String endTime) {

        if (pn == null || pn <= 0)
            pn = 1;

        List<GivenMoneyRecord> givenMoneyRecordList;
        if (startTime.equals("null")) {
            PageHelper.startPage(pn, 10);
            givenMoneyRecordList = givenMoneyRecordService.findAll();
        } else {
            PageHelper.startPage(pn, 10);
            givenMoneyRecordList  = givenMoneyRecordService.findByBetweenTime(startTime, endTime);
        }

        if (givenMoneyRecordList.size() <= 0) {
            model.addAttribute(ERROR_MSG, "赠送记录列表为空!");
        } else {
            PageInfo page = new PageInfo(givenMoneyRecordList);
            if (page.getPageNum() > 0) {
                model.addAttribute("givenMoneyRecordList", givenMoneyRecordList);
                model.addAttribute("page", page);
                model.addAttribute("pn", pn);
            }
        }

        return "admin/given-money-list";
    }
}
