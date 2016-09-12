package com.pk10.bean;

import java.util.ArrayList;
import java.util.List;

public class Datagrid {
    private int currentPage;
	private int totalPage;
	private Long total = 0L;
	private List rows = new ArrayList();

	public Long getTotal() {
		return total;
	}

	public List getRows() {
		return rows;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
