package com.pk10.control;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.*;
import com.pk10.service.GivenMoneyRecordService;
import com.pk10.service.MoneyAddRecordService;
import com.pk10.service.UserBetService;
import com.pk10.service.UserInfoService;
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
            accountChange.setBalance(moneyAddRecord.getBalance());

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
                accountChange.setBalance(bet.getCrashbalance());

                accountChanges.add(accountChange);
            }

            // 投注
            AccountChange accountChange = new AccountChange();
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



        if (accountChanges.size() < 1) {
            map.put("errorMsg", "该用户无帐变记录");
        } else {
            map.put("accountChanges", accountChanges);
       }

       return map;
    }

    @RequestMapping(value = "account-change-list/{startTime}/{endTime}", method = RequestMethod.GET)
    public String getAccountChange(Model model, @RequestParam(value = "pn", required = false) Integer pn,
                                   @PathVariable("startTime") String startTime,
                                   @PathVariable("endTime") String endTime) throws Exception {

        if (pn == null || pn <= 0)
            pn = 1;

        List<AccountChange> accountChanges = new LinkedList<AccountChange>();
        List<AccountChange> accountChangeList = new LinkedList<AccountChange>();


        List<UserInfo> users = userInfoService.getAll();
        if (startTime.equals("null")) {

            int i = 0;
            for (UserInfo user : users) {
                user = users.get(i);
                List<UserBet> bets = userBetService.getBetsByUserId(user.getId());
                List<MoneyAddRecord> moneyAddRecords = moneyAddRecordService.getMoneyAddRecordByUserId(user.getId());

                List<GivenMoneyRecord> givenMoneyRecords = givenMoneyRecordService.getGivenMoneyRecordByUserId(user.getId());

                // 充值
                for (MoneyAddRecord moneyAddRecord : moneyAddRecords) {
                    AccountChange accountChange = new AccountChange();
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

                i++;
            }
        } else {
            model.addAttribute("startTime", startTime);
            model.addAttribute("endTime", endTime);

            int i = 0;
            for (UserInfo user : users) {
                user = users.get(i);

                List<UserBet> bets = userBetService.getBetList(user.getId(), startTime, endTime);

                List<MoneyAddRecord> moneyAddRecords = moneyAddRecordService.getMoneyAddRecordList(user.getId(), startTime, endTime);

                List<GivenMoneyRecord> givenMoneyRecords = givenMoneyRecordService.getGivenMoneyList(user.getUsername(), startTime, endTime);

                // 充值
                for (MoneyAddRecord moneyAddRecord : moneyAddRecords) {
                    AccountChange accountChange = new AccountChange();
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

                i++;
            }
        }



        if (accountChanges.size() < 1) {
            model.addAttribute("accountChanges", null);
        } else {
            com.github.pagehelper.Page<AccountChange> accountChangePage = new Page<AccountChange>();
            accountChangePage.addAll(accountChanges);
            PageInfo<AccountChange> page = new PageInfo<AccountChange>(accountChangePage);
            page.setList(accountChanges);
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
            }

            if (page.getPageNum() > 0) {

                int j;
                j = pn > 1 ? (pn - 1) * 10 : 0;
                for (int i = j, c = 0; i < accountChanges.size() && c < 10; i++, c++) {
                    accountChangeList.add(accountChanges.get(i));
                }

                model.addAttribute("accountChanges", accountChangeList);
                model.addAttribute("page", page);
                model.addAttribute("pn", pn);
            }
        }

        return "admin/account-change-list";
    }
}
