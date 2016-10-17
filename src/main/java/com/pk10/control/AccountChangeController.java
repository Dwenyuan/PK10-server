package com.pk10.control;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.*;
import com.pk10.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private AccountChangeService accountChangeService;

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private MoneyAddRecordService moneyAddRecordService;

    @Resource
    private UserBetService userBetService;

    @Resource
    private GivenMoneyRecordService givenMoneyRecordService;
    private int modCount;
    private int modCount2;

    // 映射的Map不能作为返回值
    @RequestMapping(value = "{curUserId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getAccountChange(@PathVariable("curUserId")Integer curUserId,
                                                @RequestParam("startTime") String startTime,
                                                @RequestParam("endTime") String endTime) throws Exception {

        Map<String, Object> map = new LinkedHashMap<String, Object>();

        /*List<AccountChange> accountChanges = new LinkedList<>();

        UserInfo user = userInfoService.getOneById(new UserInfo(curUserId));
        List<UserBet> bets = userBetService.getBetList(curUserId, startTime, endTime);

        List<MoneyAddRecord> moneyAddRecords = moneyAddRecordService.getMoneyAddRecordList(curUserId, startTime, endTime);

        List<GivenMoneyRecord> givenMoneyRecords = givenMoneyRecordService.getGivenMoneyList(user.getUsername(), startTime, endTime);

        accountChangeStatistic(accountChanges, user, bets, moneyAddRecords, givenMoneyRecords);
*/

        modCount2 ++;

        List<AccountChange> accountChanges = accountChangeService.findByUserIdAndInTime(curUserId,
            startTime, endTime);

        if (accountChanges.size() < 1) {
            UserInfo user = userInfoService.getOneById(new UserInfo(curUserId));
            List<UserBet> bets = userBetService.getBetList(curUserId, startTime, endTime);
            List<MoneyAddRecord> moneyAddRecords = moneyAddRecordService.getMoneyAddRecordList(curUserId,
                startTime, endTime);
            List<GivenMoneyRecord> givenMoneyRecords = givenMoneyRecordService.getGivenMoneyList(user.getUsername(),
                startTime, endTime);

            accountChangeStatistic(accountChanges, user, bets, moneyAddRecords, givenMoneyRecords);

            if (modCount2 == 1) {
                // 持久化到数据库
                accountChangeService.saveCollection(accountChanges);
            }
        }

        map.put("accountChanges", accountChanges);

       return map;
    }

    @RequestMapping(value = {"account-change-list/{startTime}/{endTime}",
    "junior/{startTime}/{endTime}"}, method = RequestMethod.GET)
    public String getAccountChange(Model model, @RequestParam(value = "curAgentId", required = false)Integer agentId,
                                   @RequestParam(value = "pn", required = false) Integer pn,
                                   @PathVariable("startTime") String startTime,
                                   @PathVariable("endTime") String endTime) throws Exception {

        if (pn == null || pn <= 0)
            pn = 1;

        modCount ++;

        List<AccountChange> accountChanges = null;
        List<AccountChange> accountChangeList = new LinkedList<AccountChange>();

        String returnUrl;

        if (agentId != null) {
            returnUrl = "admin/junior-account-change-list";

            if (startTime.equals("null")) {

           /* List<UserBet> bets = userBetService.getBetsByUserId(user.getId());
            List<MoneyAddRecord> moneyAddRecords = moneyAddRecordService.getMoneyAddRecordByUserId(user.getId());

            List<GivenMoneyRecord> givenMoneyRecords = givenMoneyRecordService.getGivenMoneyRecordByUserId(user.getId());

            accountChangeStatistic(accountChanges, user, bets, moneyAddRecords, givenMoneyRecords);*/

                PageHelper.startPage(pn, 10);
                accountChanges = accountChangeService.findByAgentId(agentId);

            } else {
          /*  List<UserBet> bets = userBetService.getBetList(user.getId(), startTime, endTime);
            List<MoneyAddRecord> moneyAddRecords = moneyAddRecordService.getMoneyAddRecordList(user.getId(),
                startTime, endTime);
            List<GivenMoneyRecord> givenMoneyRecords = givenMoneyRecordService.getGivenMoneyList(user.getUsername(),
                startTime, endTime);


            accountChangeStatistic(accountChanges, user, bets, moneyAddRecords, givenMoneyRecords);*/

                PageHelper.startPage(pn, 10);
                accountChanges = accountChangeService.findByAgentIdAndInTime(agentId, startTime, endTime);

            }

        } else {
            returnUrl = "admin/account-change-list";

            if (startTime.equals("null")) {
                PageHelper.startPage(pn, 10);
                accountChanges = accountChangeService.getAll();

            } else {
                PageHelper.startPage(pn, 10);
                accountChanges = accountChangeService.findInTime(startTime, endTime);
            }
        }



        if (accountChanges.size() < 1) {
            model.addAttribute("accountChanges", null);
        } else {

           /* com.github.pagehelper.Page<AccountChange> accountChangePage = new Page<AccountChange>();
            accountChangePage.addAll(accountChanges);
            PageInfo<AccountChange> page = new PageInfo<AccountChange>(accountChangePage);
            page.setPageNum(pn);
            page.setPageSize(10);
            page.setTotal(accountChanges.size());
            page.setFirstPage(pn);
            page.setPrePage(pn-1);
            if (accountChanges.size() / 10 == 0) {
                page.setLastPage(accountChanges.size() / 10);
                page.setPages(accountChanges.size() / 10);
            } else {
                page.setLastPage(accountChanges.size() / 10 + 1);
                page.setPages(accountChanges.size() / 10 + 1);
            }
            if (pn == 1) {
                page.setIsFirstPage(true);
            } else {
                page.setIsFirstPage(false);
            }

            if (pn == accountChanges.size() % 10) {
                page.setIsLastPage(true);
            } else {
                page.setIsLastPage(false);
            }

            if (pn - 1 > 0) {
                page.setHasPreviousPage(true);
            } else {
                page.setHasNextPage(false);
            }

            if (pn + 1 < accountChanges.size() % 10) {
                page.setHasNextPage(true);
            } else {
                page.setHasNextPage(false);
            }*/

           PageInfo pageInfo = new PageInfo(accountChanges);

            if (pageInfo.getPageNum() > 0) {

                /*int j;
                j = pn > 1 ? (pn - 1) * 10 : 0;
                for (int i = j, c = 0; i < accountChanges.size() && c < 10; i++, c++) {
                    accountChangeList.add(accountChanges.get(i));
                }*/

                model.addAttribute("startTime", startTime);
                model.addAttribute("endTime", endTime);
                model.addAttribute("accountChanges", accountChanges);
                model.addAttribute("page", pageInfo);
                model.addAttribute("pn", pn);
            }

            if (accountChanges.size() > 0) {

                final int p = pn;
                final List<AccountChange> ac = accountChanges;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (p == 1 && modCount == 1) {
                            accountChangeService.saveCollection(ac);
                        }
                    }
                }).start();
            }
        }

        return returnUrl;
    }

    private void accountChangeStatistic(List<AccountChange> accountChanges, UserInfo user, List<UserBet> bets,
                                        List<MoneyAddRecord> moneyAddRecords, List<GivenMoneyRecord> givenMoneyRecords) {
        // 充值
        for (MoneyAddRecord moneyAddRecord : moneyAddRecords) {
            AccountChange accountChange = new AccountChange();
            accountChange.setUserId(user.getId());
            accountChange.setAgentId(user.getOwner());
            accountChange.setType(AccountChangeType.RECHARGE.getName());
            accountChange.setUsername(user.getUsername());
            accountChange.setMoney(moneyAddRecord.getAddMoney());
            accountChange.setTime(moneyAddRecord.getAddTime());
            accountChange.setBalance(moneyAddRecord.getBalance());

            accountChanges.add(accountChange);
        }

        for (UserBet bet : bets) {
            // 中奖
            if (bet.getState() == 1) {
                AccountChange accountChange = new AccountChange();
                accountChange.setUserId(user.getId());
                accountChange.setAgentId(user.getOwner());
                accountChange.setType(AccountChangeType.LOTTERY.getName());
                accountChange.setUsername(user.getUsername());
                // 中奖金额
                accountChange.setMoney(bet.getBetmoney() * bet.getOdds());
                accountChange.setTime(bet.getCreatedAt());
                accountChange.setBalance(bet.getCrashbalance());

                accountChanges.add(accountChange);
            }

            // 投注
            AccountChange accountChange = new AccountChange();
            accountChange.setUserId(user.getId());
            accountChange.setAgentId(user.getOwner());
            accountChange.setType(AccountChangeType.BET.getName());
            accountChange.setUsername(user.getUsername());
            accountChange.setMoney(bet.getBetmoney());
            accountChange.setTime(bet.getCreatedAt());
            accountChange.setBalance(bet.getBalance());

            accountChanges.add(accountChange);
        }

        // 收入,支出
        for (GivenMoneyRecord givenMoneyRecord : givenMoneyRecords) {
            AccountChange accountChange = new AccountChange();
            accountChange.setUserId(user.getId());
            accountChange.setAgentId(user.getOwner());
            // 当前用户和赠送记录表的用户相同则为支出
            if (user.getUsername().equals(givenMoneyRecord.getCurrentUsername())) {
                accountChange.setType(AccountChangeType.DEFRAY.getName());
                accountChange.setBalance(givenMoneyRecord.getCurrentMoney());
            } else if (user.getUsername().equals(givenMoneyRecord.getOpposingUsername())) {
                accountChange.setType(AccountChangeType.INCOME.getName());
                accountChange.setBalance(givenMoneyRecord.getOpposingMoney());
            }
            accountChange.setUsername(user.getUsername());
            accountChange.setMoney(givenMoneyRecord.getGivenMoney());
            accountChange.setTime(givenMoneyRecord.getTime());

            accountChanges.add(accountChange);
        }

    }
}
