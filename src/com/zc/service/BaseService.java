package com.zc.service;

public interface BaseService {
	boolean add(Object object);
	boolean update(String name);
	boolean delete(Integer id);
	boolean get(Integer id);
}
