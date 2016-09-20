package com.pk10.control;

import com.pk10.bean.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ron on 16-9-7.
 */
@Deprecated
@Controller
public class AdminHomeControl {
    private static final Logger log = LoggerFactory.getLogger(UserInfoControl.class);

    @RequestMapping("toAdminHome")
    public String toAdminHome(HttpServletRequest request) {
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userinfo");
        log.debug("toAdminHome: userInfo = " + userInfo);
        if (userInfo != null) {
            if(userInfo.getIsagent() == 3){
                return "admin/admin-index";
            }else if(userInfo.getIsagent() != 0){
                return "admin/admin-agent";
            }else {
                return "redirect:userlogin.html";
            }
        } else {
            return "redirect:admin-login.htm";
        }
    }

}
