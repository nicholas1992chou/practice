package com.zc.service;

import java.util.List;

import com.zc.basic_practice.Banji;

public interface BanjiService{
	Banji get(Integer id, List<Banji> list);
	List<Integer> getBanIds(List<Banji> list);
	void delete(List<Banji> list, Integer id);
}
