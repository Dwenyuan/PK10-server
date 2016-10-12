package com.pk10.control;

import com.pk10.bean.GivenMoneyRecord;
import com.pk10.service.GivenMoneyRecordService;
import com.pk10.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dengfengdecao on 16/10/11.
 */
@RestController
public class GivenMoneyController {

    public static final Logger log = LoggerFactory.getLogger(GivenMoneyController.class);

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private GivenMoneyRecordService givenMoneyRecordService;

    @RequestMapping(value = "given-money/{curUsername}", method = RequestMethod.GET)
    public Object givenMoneyRecord(@PathVariable("curUsername")String curUsername,
                                   @RequestParam("startTime")String startTime,
                                   @RequestParam("endTime")String endTime) {
        List<GivenMoneyRecord> givenMoneyRecords = givenMoneyRecordService.getGivenMoneyList(curUsername, startTime,
            endTime);



        return givenMoneyRecords;
    }
}
