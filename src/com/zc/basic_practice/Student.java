package com.zc.basic_practice;
import java.io.Serializable;



public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Integer count=0;
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private Banji ban;
	private Score score; 
	
	public Student(){
		count++;
		id = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	

	public Banji getBan() {
		return ban;
	}

	public void setBan(Banji ban) {
		this.ban = ban;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Integer getId() {
		return id;
	}
	
}
