package com.pk10.control;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.MoneyAddRecord;
import com.pk10.service.MoneyAddRecordService;
import com.pk10.service.UserInfoService;
import com.pk10.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pk10.util.Const.ERROR_MSG;

/**
 * Created by ron on 16-9-5.
 */
@Controller
@RequestMapping("money-add-record")
public class MoneyAddRecordController {

    private static final Logger logger = LoggerFactory.getLogger(MoneyAddRecordController.class);
    @Resource
    MoneyAddRecordService moneyAddRecordService;
    @Resource
    UserInfoService userInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String addMoneyRecords(Model model, @RequestParam(value = "pn", required = false)Integer pn){
        Map<String, Object> map = new HashMap<>();
        try {
            if (pn == null || pn <= 0)
                pn = 1;

            PageHelper.startPage(pn, 10);
            List<MoneyAddRecord> records = moneyAddRecordService.getAll();
            if (records == null) {

                map.put(ERROR_MSG, "没有充值记录!");
            } else {
                PageInfo page = new PageInfo(records);
                if (page.getPageNum() > 0) {
                    model.addAttribute("records", records);
                    model.addAttribute("page", page);
                    model.addAttribute("pn", pn);
                }
            }
        } catch(Exception e){
            map.put(ERROR_MSG, e.getMessage());
            logger.error(e.getMessage());
        }

        return "admin/money-add-record";
    }

    @RequestMapping(value = "/record-list/{startTime}/{endTime}", method = RequestMethod.GET)
    @ResponseBody
    public String getMoneyRecordList(@RequestParam("id")int id, @PathVariable("startTime")String startTime,
                                     @PathVariable("endTime")String endTime){


        Map<String, Object> map = new HashMap<>();
        try {
            List<MoneyAddRecord> records = moneyAddRecordService.findByIdAndTime(id, startTime, endTime);
            if (records != null)
                map.put("records", records);
            else
                map.put(ERROR_MSG, "该用户没有充值记录!");
        } catch(Exception e){
            map.put(ERROR_MSG, e.getMessage());
        }

        return JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss");
    }


    @RequestMapping(value = "/{startTime}/{endTime}", method = RequestMethod.GET)
    public String getMoneyRecords(Model model, @RequestParam(value = "pn", required = false)Integer pn,
                                  @RequestParam(value = "curAgentId", required = false)Integer curAgentId,
                                  @PathVariable("startTime")String startTime,
                                  @PathVariable("endTime")String endTime){

        String returnUrl = "admin/money-add-record";

        try {
            if (pn == null || pn <= 0)
                pn = 1;

            // 找出当前请求的代理商下得所有充值记录
            List<MoneyAddRecord> moneyAddRecords = null;
            if (curAgentId != null && curAgentId != 0) {
                PageHelper.startPage(pn, 10);
                moneyAddRecords = moneyAddRecordService.findByAgentIdAndTime(curAgentId,
                    startTime, endTime);

                // 代理商下的充值列表
                returnUrl = "admin/junior-money-add-record";
            } else {
                // 查出所有充值记录,可按时间区间搜索
                PageHelper.startPage(pn, 10);
                moneyAddRecords = moneyAddRecordService.findByTimeBetween(startTime, endTime);
            }

            if (moneyAddRecords != null && moneyAddRecords.size() > 0) {
                PageInfo page = new PageInfo(moneyAddRecords);
                if (page.getPageSize() > 0) {
                    model.addAttribute("startTime", startTime);
                    model.addAttribute("endTime", endTime);
                    model.addAttribute("records", moneyAddRecords);
                    model.addAttribute("page", page);
                    model.addAttribute("pn", pn);
                }
            } else {
                model.addAttribute(Const.ERROR_MSG, "无充值记录信息可显示!");
            }

        } catch(Exception e){
            logger.error(e.getMessage());
        }

        return returnUrl;
    }
}
