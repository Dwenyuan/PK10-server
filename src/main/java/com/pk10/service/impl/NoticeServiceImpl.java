package com.pk10.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.Datagrid;
import com.pk10.bean.Page;
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
	public Datagrid getAllInPage(Page page) throws Exception {
		PageHelper.startPage(page.getPages(),1);
		List<Notice> notices = noticeDao.getAll();
		PageInfo pageInfo = new PageInfo(notices);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(notices);
		datagrid.setTotal(pageInfo.getTotal());
		datagrid.setTotalPage(pageInfo.getPages());
		datagrid.setCurrentPage(page.getPages());
		return datagrid;
	}

	@Override
	public List<Notice> getAll() throws Exception {
		return null;
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

	@Override
	public int updateByPrimaryKey(Notice notice) {
		return noticeDao.updateByPrimaryKeySelective(notice);
	}
}