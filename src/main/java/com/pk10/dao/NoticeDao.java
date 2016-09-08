package com.pk10.dao;

import com.pk10.bean.Notice;

public interface NoticeDao extends BaseDao<Notice> {
	public Notice getLastNotice() throws Exception;

	int updateByPrimaryKeySelective(Notice notice);
}
