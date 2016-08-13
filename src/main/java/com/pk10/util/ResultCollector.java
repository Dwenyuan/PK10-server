package com.pk10.util;

import java.text.SimpleDateFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

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
			Document document = Jsoup.connect(url).get();
			Elements elements = document.select("table.tb > tbody > tr");
			for (int i = 1; i < elements.size(); i++) {
				Elements tds = elements.get(i).select("td");
				lotteryHistoryService.save(new LotteryHistory(Integer.parseInt(tds.get(0).text()), simpleDateFormat.parse(tds.get(2).text()), tds.get(1).text()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.info("task - 执行收集开奖结果");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.collector();
	}
}
