package com.pk10.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ron on 16-9-7.
 */
@Controller
public class AdminHomeControl {
    @RequestMapping("toAdminHome")
    public String toAdminHome(){
        return "admin/admin-index";
    }

}
