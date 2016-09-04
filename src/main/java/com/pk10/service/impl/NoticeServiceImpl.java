package com.pk10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk10.bean.Notice;
import com.pk10.dao.NoticeDao;
import com.pk10.service.NoticeService;



@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public Integer save(Notice t) throws Exception {
		return noticeDao.save(t);
	}

	@Override
	public Integer update(Notice t) throws Exception {
		return noticeDao.update(t);
	}

	@Override
	public List<Notice> getAll() throws Exception {
		return noticeDao.getAll();
	}

	@Override
	public Notice getOneById(Notice t) throws Exception {
		return noticeDao.getOneById(t);
	}

	@Override
	public Integer deleteOneById(Notice t) throws Exception {
		return noticeDao.deleteOneById(t);
	}

	@Override
	public Notice getLastNotice() throws Exception {
		return noticeDao.getLastNotice();
	}

}
