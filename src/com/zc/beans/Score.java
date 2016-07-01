package com.zc.beans;
import java.io.Serializable;


public class Score implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer math;
	private Integer english;
	private Integer chinese;
	
	public Score(){
		super();
	}
	public Score(Integer math, Integer english, Integer chinese){
		if(math < 0 || math > 100){
			try {
				throw new Exception("math 有效范围：0 — 100");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(english < 0 || english > 100){
			try {
				throw new Exception("english 有效范围：0 — 100");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(chinese < 0 || chinese > 100){
			try {
				throw new Exception("chinese 有效范围：0 — 100");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.math = math;
		this.english = english;
		this.chinese = chinese;
	}
	
	public Integer getMath() {
		return math;
	}
	public void setMath(Integer math) {
		if(math < 0 || math > 100){
			try {
				throw new Exception("math 有效范围：0 — 100");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.math = math;
	}
	public Integer getEnglish() {
		return english;
	}
	public void setEnglish(Integer english) {
		if(english < 0 || english > 100){
			try {
				throw new Exception("english 有效范围：0 — 100");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.english = english;
	}
	public Integer getChinese() {
		return chinese;
	}
	public void setChinese(Integer chinese) {
		if(chinese < 0 || chinese > 100){
			try {
				throw new Exception("chinese 有效范围：0 — 100");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.chinese = chinese;
	}
	@Override
	public String toString() {
		return "Score [math=" + math + ", english=" + english + ", chinese="
				+ chinese + "]";
	}
}
