package com.pk10.control;

import com.pk10.bean.*;
import com.pk10.service.MoneyAddRecordService;
import com.pk10.service.UserBetService;
import com.pk10.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by dengfengdecao on 16/9/26.
 */
@Controller
@RequestMapping("account-change")
public class AccountChangeController {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    MoneyAddRecordService moneyAddRecordService;

    @Resource
    private UserBetService userBetService;

    // 映射的Map不能作为返回值
    @RequestMapping(value = "{curUserId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAccountChange(@PathVariable("curUserId")Integer curUserId,
                                                @RequestParam("startTime") String startTime,
                                                @RequestParam("endTime") String endTime) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        List<AccountChange> accountChanges = new LinkedList<AccountChange>();
        UserInfo user = userInfoService.getOneById(new UserInfo(curUserId));
        List<MoneyAddRecord> moneyAddRecords = moneyAddRecordService.getMoneyAddRecordList(curUserId, startTime, endTime);
        List<UserBet> bets = userBetService.getBetList(curUserId, startTime, endTime);

        for (MoneyAddRecord moneyAddRecord : moneyAddRecords) {
            AccountChange accountChange = new AccountChange();
            accountChange.setType(AccountChangeType.RECHARGE);
            accountChange.setUsername(user.getUsername());
            accountChange.setMoney(moneyAddRecord.getAddMoney());
            accountChange.setTime(moneyAddRecord.getAddTime());
            accountChanges.add(accountChange);
        }

        for (UserBet bet : bets) {
            // 中奖
            if (bet.getState() == 1) {
                AccountChange accountChange = new AccountChange();
                accountChange.setType(AccountChangeType.LOTTERY);
                accountChange.setUsername(user.getUsername());
                // 中奖金额
                accountChange.setMoney(bet.getBetmoney() * bet.getOdds());
                accountChange.setTime(bet.getCreatedAt());
                accountChanges.add(accountChange);
            }

            // 投注
            AccountChange accountChange = new AccountChange();
            accountChange.setType(AccountChangeType.BET);
            accountChange.setUsername(user.getUsername());
            accountChange.setMoney(bet.getBetmoney());
            accountChange.setTime(bet.getCreatedAt());
            accountChanges.add(accountChange);
        }

        if (accountChanges.size() < 1) {
            map.put("errorMsg", "该用户无帐变记录");
        } else {
            map.put("accountChanges", accountChanges);
        }
        return map;
    }
}
