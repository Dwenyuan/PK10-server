package com.pk10.control;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.MoneyAddRecord;
import com.pk10.service.MoneyAddRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    private static final Logger logger = LoggerFactory.getLogger(MoneyAddRecordController.class);
    @Resource
    MoneyAddRecordService moneyAddRecordService;

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

    @RequestMapping("/record-list")
    @ResponseBody
    public String getMoneyRecordList(@RequestParam("id")int id){
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
