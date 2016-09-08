package com.pk10.service;

import com.pk10.bean.Notice;

import java.util.List;

public interface NoticeService extends BaseService<Notice>{
	public Notice getLastNotice() throws Exception;

	public int updateByPrimaryKey(Notice notice);


}
