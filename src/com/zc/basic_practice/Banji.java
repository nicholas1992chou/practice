package com.zc.basic_practice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Banji implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Integer count ;
	private Integer stuCount = 0;
	static{
		count = 201600;
		if(Util.fileExists()){//保存信息的文件存在
			if( !Util.getBanjiList().isEmpty()){//集合里有元素
				count = Util.getBanjiList().get(Util.getBanjiList().size()-1).getId();
			}
		}	
	}
	private Integer id;
	private List<Student> students = new ArrayList<>();
	
	public Banji(){
		count++;
		id = count;
	}
	
	
	public  Integer getId() {
		return id;
	}


	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public Integer getStuCount() {
		return stuCount;
	}


	public void setStuCount(Integer stuCount) {
		this.stuCount = stuCount;
	}


	@Override
	public String toString() {
		return "Banji [id=" + id + ", students="
				+ students + "]";
	}
	
	
	
}
