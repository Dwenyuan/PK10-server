package com.pk10.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.pk10.bean.BetType;
import com.pk10.bean.UserBet;

public class TestDate {

	@Test
	public void getTime() throws ParseException {
		System.out.println(new SimpleDateFormat("HH").format(new Date()));
		System.out.println(new SimpleDateFormat("MM").format(new Date()));
		Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-08-18 23:57:00");
		Date date = new Date();
		long diff = date.getTime() - parse.getTime();
		System.out.println(diff / (1000 * 60));
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

	@Test
	public void TestGetLastDate() throws ParseException {
		List<Date> list = new ArrayList<Date>();
		list.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-08-21 11:57:00"));
		list.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-08-21 11:58:00"));
		list.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-08-21 14:36:00"));
		list.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-08-21 11:56:00"));

		Boolean isLastDate = this.getIsLastDate(list);
		System.out.println(isLastDate);

		// Date lastDate = this.getLastDate(list);
		// System.out.println(lastDate);
		// long sec = (new Date().getTime() - lastDate.getTime()) / (1000);
		// System.out.println(sec);
		// System.out.println(new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss").format(this.getLastDate(list)));
	}

	@Test
	public void TestRegix() {
		Pattern compile = Pattern
				.compile("\\/(login|register|checkTel|checkusername)|userlogin\\.html|\\/build\\/\\w+\\.\\w+");
		Matcher matcher = compile.matcher("/getLastNotice");
		boolean find = matcher.find();
		System.out.println(find);
	}

	@Test
	public void TestTime() throws ParseException {
		Date now = new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(new Date()));
		System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(now));
	}

	@Test
	public void TestDate() throws Exception {
		Date date1 = new Date();
		Thread.sleep(2000);
		Date date2 = new Date();
		System.out.println(System.currentTimeMillis() - date1.getTime());
	}
}
