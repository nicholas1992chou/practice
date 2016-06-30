package com.zc.basic_practice;

import java.io.Serializable;
import java.util.List;


public class Banji implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Integer count = 201600;
	private Integer id;
	private List<Student> students;
	
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
	
	
	
}
