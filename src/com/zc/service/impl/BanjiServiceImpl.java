package com.zc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zc.basic_practice.Banji;
import com.zc.basic_practice.Util;
import com.zc.service.BanjiService;

public class BanjiServiceImpl implements BanjiService{
	public Banji get(Integer id, List<Banji> list){
		for(Banji banji: list){
			if(banji.getId().equals(id)){
				return banji;
			}
		}
		return null;
	}
	public void delete(List<Banji> list, Integer id) {
		boolean Searchflag = false;
		for (Banji banji : list) {
			if (banji.getId().equals(id)) {// ʹ�ð�װ��Ƚ���ֵ��ȣ���equals
				list.remove(banji);
				Searchflag = true;
				break;
			}
		}
		if (Searchflag) {
			System.out.println("ɾ���ɹ�");
		} else
			System.out.println("ɾ��ʧ��");
	}
	public List<Integer> getBanIds(List<Banji> list){
		if(list != null){
			List<Integer> iList = new ArrayList<>();
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			for(Banji banji : list){
				System.out.println(banji.getId());
				iList.add(banji.getId());
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			}
			return iList;
		}
		return null;
	}
}
