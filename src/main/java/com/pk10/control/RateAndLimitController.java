package com.pk10.control;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.Betlimit;
import com.pk10.service.RateAndLimitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by ron on 16-9-3.
 */
@Controller
public class RateAndLimitController {

    @Resource
    RateAndLimitService rateAndLimitService;

    private static final Logger logger = LoggerFactory.getLogger(RateAndLimitController.class);
    @RequestMapping("getAllRateAndLimit")
    @ResponseBody
    public Object getAllRateAndLimit(){   //获取大小单双和0-9的概率和限制
        try {
            return rateAndLimitService.getRateAndLimit();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JSON.parse("{errmsg:" + e.getMessage() + "}");
        }
    }

    @RequestMapping("updateRateAndLimit")  //修改大小单双和0-9的概率和限制
    public void updateRateAndLimit(@RequestBody Betlimit betlimit) {
        rateAndLimitService.updateRateAndLimit(betlimit);
    }
}
