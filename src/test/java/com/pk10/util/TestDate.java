package com.pk10.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestDate {

	@Test
	public void getTime() throws ParseException {
		System.out.println(new SimpleDateFormat("hh").format(new Date()));
		System.out.println(new SimpleDateFormat("MM").format(new Date()));
		Date parse = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2016-08-18 23:57:00");
		Date date = new Date();
		long diff = date.getTime() - parse.getTime();
		System.out.println(diff / (1000 * 60));
	}
}
