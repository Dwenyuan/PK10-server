package com.pk10.control;

import com.pk10.bean.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ron on 16-9-10.
 */
public class MoneyAddRecordCotroller {
    /**
     * 充值记录
     */
    @RequestMapping("toMoneyAddRecord")
    public Object toMoneyAddRecord(Model model, Page page){
        return "admin/useraddrecord";
    }
}
