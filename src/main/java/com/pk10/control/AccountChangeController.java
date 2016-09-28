package com.pk10.control;

import com.pk10.bean.*;
import com.pk10.service.GivenMoneyRecordService;
import com.pk10.service.MoneyAddRecordService;
import com.pk10.service.UserBetService;
import com.pk10.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by dengfengdecao on 16/9/26.
 */
@Controller
@RequestMapping("account-change")
public class AccountChangeController {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private MoneyAddRecordService moneyAddRecordService;

    @Resource
    private UserBetService userBetService;

    @Resource
    private GivenMoneyRecordService givenMoneyRecordService;


    // 映射的Map不能作为返回值
    @RequestMapping(value = "{curUserId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getAccountChange(@PathVariable("curUserId")Integer curUserId,
                                                @RequestParam("startTime") String startTime,
                                                @RequestParam("endTime") String endTime) throws Exception {

        Map<String, Object> map = new LinkedHashMap<String, Object>();

        List<AccountChange> accountChanges = new LinkedList<AccountChange>();

        UserInfo user = userInfoService.getOneById(new UserInfo(curUserId));
        List<UserBet> bets = userBetService.getBetList(curUserId, startTime, endTime);

        List<MoneyAddRecord> moneyAddRecords = moneyAddRecordService.getMoneyAddRecordList(curUserId, startTime, endTime);

        List<GivenMoneyRecord> givenMoneyRecords = givenMoneyRecordService.getGivenMoneyList(user.getUsername(), startTime, endTime);

        // 充值
        for (MoneyAddRecord moneyAddRecord : moneyAddRecords) {
            AccountChange accountChange = new AccountChange();
            accountChange.setType(AccountChangeType.RECHARGE.getName());
            accountChange.setUsername(user.getUsername());
            accountChange.setMoney(moneyAddRecord.getAddMoney());
            accountChange.setTime(moneyAddRecord.getAddTime());
            accountChange.setBalance(user.getMoney());

            accountChanges.add(accountChange);
        }

        for (UserBet bet : bets) {
            // 中奖
            if (bet.getState() == 1) {
                AccountChange accountChange = new AccountChange();
                accountChange.setType(AccountChangeType.LOTTERY.getName());
                accountChange.setUsername(user.getUsername());
                // 中奖金额
                accountChange.setMoney(bet.getBetmoney() * bet.getOdds());
                accountChange.setTime(bet.getCreatedAt());
                accountChange.setBalance(user.getMoney());

                accountChanges.add(accountChange);
            }

            // 投注
            AccountChange accountChange = new AccountChange();
            accountChange.setType(AccountChangeType.BET.getName());
            accountChange.setUsername(user.getUsername());
            accountChange.setMoney(bet.getBetmoney());
            accountChange.setTime(bet.getCreatedAt());
            accountChange.setBalance(user.getMoney());

            accountChanges.add(accountChange);
        }

        // 收入,支出
        for (GivenMoneyRecord givenMoneyRecord : givenMoneyRecords) {
            AccountChange accountChange = new AccountChange();
            // 当前用户和赠送记录表的用户相同则为支出
            if (user.getUsername().equals(givenMoneyRecord.getCurrentUsername())) {
                accountChange.setType(AccountChangeType.DEFRAY.getName());
            } else if (user.getUsername().equals(givenMoneyRecord.getOpposingUsername())) {
                accountChange.setType(AccountChangeType.INCOME.getName());
            }
            accountChange.setUsername(user.getUsername());
            accountChange.setMoney(givenMoneyRecord.getGivenMoney());
            accountChange.setTime(givenMoneyRecord.getTime());
            accountChange.setBalance(user.getMoney());

            accountChanges.add(accountChange);
        }



        if (accountChanges.size() < 1) {
            map.put("errorMsg", "该用户无帐变记录");
        } else {
            map.put("accountChanges", accountChanges);
       }

       // JSON.parse(JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss"));
        return map;
    }
}
