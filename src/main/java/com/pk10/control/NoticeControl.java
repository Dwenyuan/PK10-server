package com.pk10.control;

import com.pk10.bean.Datagrid;
import com.pk10.bean.Notice;
import com.pk10.bean.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.nativejdbc.OracleJdbc4NativeJdbcExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pk10.service.NoticeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoticeControl {
	private static final Logger logger = LoggerFactory.getLogger(NoticeControl.class);
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value="getLastNotice")
	@ResponseBody
	public Object getLastNotice() {
		try {
			return JSON.toJSON(noticeService.getLastNotice());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("toNotice")
	public Object toNotice(Model model, Page page){
		try{

				page.setPages(1);
				Datagrid notices = noticeService.getAllInPage(page);

			model.addAttribute("notices",notices);
			return "admin/notify";
		}catch (Exception e){
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("getNoticeInPage")
	@ResponseBody
	public Object getNoticeInPage(@RequestBody Model model, Page page){
		try{
			return noticeService.getAllInPage(page);
		}catch (Exception e){
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}
}
