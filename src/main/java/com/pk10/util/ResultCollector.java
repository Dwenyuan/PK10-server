package com.pk10.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.xml.crypto.Data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.pk10.bean.LotteryHistory;
import com.pk10.service.LotteryHistoryService;

/**
 * 中奖结果采集器
 * 
 * @author Administrator
 *
 */
public class ResultCollector implements InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(ResultCollector.class);

	private String url;

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Autowired
	public LotteryHistoryService lotteryHistoryService;

	public void collector() {
		try {
			for (int j = 0; j < 20; j++) { // 读取20次开奖结果，如果还没有得到正确结果 则超时
				List<Date> list = new ArrayList<Date>();// 日期列表
				Document document = Jsoup.connect(url).get();
				Elements elements = document.select("table.tb > tbody > tr");
				for (int i = 1; i < elements.size(); i++) {
					Elements tds = elements.get(i).select("td");
					list.add(simpleDateFormat.parse(tds.get(2).text()));
				}
				Boolean isReadSuccess = this.getIsLastDate(list);
				if (!isReadSuccess) {
					Thread.sleep(5000);
					continue;
				}
				for (int i = 1; i < elements.size(); i++) {
					Elements tds = elements.get(i).select("td");
					lotteryHistoryService.save(new LotteryHistory(Integer.parseInt(tds.get(0).text()), simpleDateFormat.parse(tds.get(2).text()), tds.get(1).text()));
				}
				break;// 读取成功后跳出循环
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("task - get collector result");
	}

	private Boolean getIsLastDate(List<Date> list) {
		Date LastDate = null;
		for (Date date : list) {
			if (LastDate == null) {
				LastDate = date;
			} else {
				if (LastDate.getTime() < date.getTime()) {
					LastDate = date;
				}
			}
		}
		if ((new Date().getTime() - LastDate.getTime()) / (1000) > 300) { // 如果当前时间距离开奖时间超过5分钟表示没有读取成功，读取的还是上次的开奖结果
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.collector();
	}
}
