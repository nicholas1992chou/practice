package com.zc.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.zc.beans.Banji;
import com.zc.beans.Util;
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
		ListIterator<Banji> listIterator = list.listIterator();
		while(listIterator.hasNext()){
			if(listIterator.next().getId().equals(id)){
				listIterator.remove();
				Searchflag = true;
			}
		}
		if (Searchflag) {
			System.out.println("É¾³ý³É¹¦");
		} else
			System.out.println("É¾³ýÊ§°Ü");
	}
	public boolean update(Banji banji, List<Banji> banjiList){
		ListIterator<Banji> lIterator = banjiList.listIterator();
		while(lIterator.hasNext()){
			Banji banji2 = lIterator.next();
			if(banji2.getId().equals(banji.getId())){
				lIterator.set(banji);
				return true;
			}
		}
		return false;
	}
	public List<Integer> getBanIds(List<Banji> list){
		if(list != null){
			List<Integer> iList = new ArrayList<>();
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			for(Banji banji : list){
				//System.out.println(banji.getId());
				System.out.println(banji);
				iList.add(banji.getId());
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			}
			return iList;
		}
		return null;
	}
}
