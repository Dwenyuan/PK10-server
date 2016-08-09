package com.pk10.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.pk10.service.LotteryHistoryService;

/**
 * 自动生成中奖码以及倒计时
 * 
 * @author Administrator
 *
 */
public class CreateBonus implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(CreateBonus.class);

	private static Integer count; // 倒计时

	private static String idnum;
	private static Integer countNum;

	@Autowired
	private TokenConfig tokenConfig;

	@Autowired
	private LotteryHistoryService lotteryHistoryService;

	public static String getIdnum() {
		return idnum;
	}

	public static void setIdnum(String idnum) {
		CreateBonus.idnum = idnum;
	}

	public static Integer getCountNum() {
		return countNum;
	}

	public static void setCountNum(Integer countNum) {
		CreateBonus.countNum = countNum;
	}

	public static Integer getCount() {
		return count;
	}

	public static void setCount(Integer count) {
		CreateBonus.count = count;
	}

	public static Logger getLogger() {
		return logger;
	}

	public CreateBonus() {
		super();
	}

	public void run() {
		countNum = tokenConfig.getLotteryTime();
		count = tokenConfig.getLotteryTime();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					idnum = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());// 开奖期数
					while (true) {
						Thread.sleep(1000);// 一秒钟倒计时 减一
						if (count > 0) {
							count--;
							System.out.println(Thread.currentThread().getName() + "count number is " + count);
						} else {
							lotteryHistoryService.update(new LotteryHistory(idnum, new Date(), new Random().nextInt(10), new Random().nextInt(10)));
							idnum = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());// 开奖期数
							lotteryHistoryService.save(new LotteryHistory(idnum, null, null, null));
							logger.info("开奖时间到，数据库写入开奖结果");
							count = tokenConfig.getLotteryTime();
						}
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}).start();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.run();
	}
}
