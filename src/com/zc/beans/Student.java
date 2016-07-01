package com.zc.beans;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String name;
	private String sex;
	private Date birth;
	private Banji ban;
	private Score score; 
	
	public Student(){   
		super();
	}
	public Student(String name, String sex, Date birth, Banji ban, Score score){
		this.id = ban.getStuCount() + 1;
		ban.setStuCount(ban.getStuCount() + 1);
		this.name = name;
		if("男".equals(sex) || "女".equals(sex))
			this.sex = sex;
		else{
			try {
				throw new Exception("sex 只能为 男或女");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.birth = birth;
		this.ban = ban;
		this.score = score;
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
		if("男".equals(sex) || "女".equals(sex))
			this.sex = sex;
		else{
			try {
				throw new Exception("sex 只能为 男或女");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Banji getBan() {
		return ban;
	}

	public void setBan(Banji ban) {
		this.id = ban.getStuCount() + 1;
		ban.setStuCount(ban.getStuCount() + 1);
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", birth=" + new SimpleDateFormat("yyyy-MM-dd").format(birth) + ", banji=" + ban.getId() + ", score=" + score
				+ "]\n";
	}
	
}
