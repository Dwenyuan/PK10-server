package com.pk10.service;

import java.util.List;

public interface BaseService<T> {
	public Integer save(T t) throws Exception;

	public Integer update(T t) throws Exception;

	public List<T> getAll() throws Exception;

	public T getOneById(T t) throws Exception;

	public Integer deleteOneById(T t) throws Exception;
}
