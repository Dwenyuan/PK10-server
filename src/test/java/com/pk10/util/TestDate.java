package com.pk10.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestDate {

	@Test
	public void getTime(){
		System.out.println(new SimpleDateFormat("hh").format(new Date()));
		System.out.println(new SimpleDateFormat("MM").format(new Date()));
	}
}
