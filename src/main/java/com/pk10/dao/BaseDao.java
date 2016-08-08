package com.pk10.dao;

import java.util.List;

public interface BaseDao<T> {
	public Integer save(T t) throws Exception;

	public Integer update(T t) throws Exception;

	public List<T> getAll() throws Exception;

	public T getOneById(T t) throws Exception;

	public Integer deleteOneById(T t) throws Exception;
}
