package com.pk10.control;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.MoneyAddRecord;
import com.pk10.service.MoneyAddRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping("/record-list")
    @ResponseBody
    public String getMoneyRecordList(HttpServletResponse response, @RequestParam("id")int id){
        Map<String, Object> map = new HashMap<>();
        try {
            List<MoneyAddRecord> records = moneyAddRecordService.getMoneyAddRecordByUserId(id);
            if (records != null)
                map.put("records", records);
            else
                map.put(ERROR_MSG, "该用户没有充值记录!");
        } catch(Exception e){
            map.put(ERROR_MSG, e.getMessage());
        }

        return JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss");
    }


}
