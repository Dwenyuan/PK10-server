package com.pk10.control;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("getpath")
	@ResponseBody
	public String getPath(HttpServletRequest request){
		return request.getRequestURL().toString();
	}
	
	@RequestMapping("error")
	public String main(){
		return "redirect:/userlogin.html";
	}
}
