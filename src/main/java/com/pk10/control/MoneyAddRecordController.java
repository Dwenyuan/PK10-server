package com.pk10.control;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.MoneyAddRecord;
import com.pk10.service.MoneyAddRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by ron on 16-9-5.
 */
@Controller
public class MoneyAddRecordController {
    @Resource
    MoneyAddRecordService moneyAddRecordService;

    @RequestMapping("addMoneyRecord")
    @ResponseBody
    public Object addMoneyRecord(@RequestBody MoneyAddRecord moneyAddRecord){
        try {
            return moneyAddRecordService.insertMoneyAddRecord(moneyAddRecord);
        }catch(Exception e){
            return JSON.parse("{errmsg:" + e.getMessage() + "}");
        }
    }

    @RequestMapping("getMoneyRecord")
    @ResponseBody
    public Object getMoneyRecord(@RequestBody MoneyAddRecord moneyAddRecord){
        try {
            return moneyAddRecordService.getMoneyAddRecordByUserId(moneyAddRecord.getUserId());
        }catch(Exception e){
            return JSON.parse("{errmsg:" + e.getMessage() + "}");
        }
    }
}
