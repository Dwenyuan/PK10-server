package com.pk10.service;

import com.pk10.bean.Notice;

public interface NoticeService extends BaseService<Notice>{
	public Notice getLastNotice() throws Exception;
}
