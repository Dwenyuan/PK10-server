package com.pk10.control;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.BetInit;
import com.pk10.service.BetInitService;
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
public class BetInitController {
    private static final Logger logger = LoggerFactory.getLogger(BetInitController.class);

    @Resource
    BetInitService betInitService;

    @RequestMapping("getAllGameInitDate")
    @ResponseBody
    public Object getAllGameInitDate(){
        try {
            return betInitService.getAllBetInit();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JSON.parse("{errmsg:" + e.getMessage() + "}");
        }
    }

    @RequestMapping("getGameInitDate")
    @ResponseBody
    public Object getGameInitDate(@RequestBody BetInit betInit){
        try {
            return betInitService.getBetInitByName(betInit);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JSON.parse("{errmsg:" + e.getMessage() + "}");
        }
    }

    @RequestMapping("updateGameInitDate")
    @ResponseBody
    public Object updateGameInitDate(@RequestBody BetInit betInit){
        try {
            return betInitService.updateBetInit(betInit);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JSON.parse("{errmsg:" + e.getMessage() + "}");
        }
    }
}
