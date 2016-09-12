package com.pk10.control;

import com.pk10.bean.Datagrid;
import com.pk10.bean.Page;
import com.pk10.bean.RateHistory;
import com.pk10.service.RateHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by ron on 16-9-10.
 */
@Controller
public class RateHistoryController {

    @Resource
    RateHistoryService rateHistoryService;

    @RequestMapping("toRateHistory")
    public Object toRateHistory(Model model, Page page){
        if(page.getPages() == 0){
            page.setPages(1);
            Datagrid datagrid = rateHistoryService.getAll(page);
            model.addAttribute("rateHistory",datagrid);
            return "admin/ratehistory";
        }else{

            Datagrid datagrid = rateHistoryService.getAll(page);
            model.addAttribute("rateHistory",datagrid);
            return "admin/ratehistory";
        }
    }

    @RequestMapping("getRateHistoryByUsername")
    @ResponseBody
    public Object getRateHistoryByUsername(@RequestBody  RateHistory rateHistory){
        return rateHistoryService.getRateHistoryByUsername(rateHistory);
    }
}
