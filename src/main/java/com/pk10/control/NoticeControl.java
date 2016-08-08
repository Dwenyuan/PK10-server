package com.pk10.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pk10.service.NoticeService;

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
			return "{errmsg:" + e.getMessage() + "}";
		}
	}
}
