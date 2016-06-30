package com.zc.basic_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class Test {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Banji> banjis = new ArrayList<Banji>();
//		Banji banji = new Banji();
//		List<Student> student = new ArrayList<Student>();
//		Student student2 = new Student();
//		student2.setName("nicholas");
//		student2.setAge(22);
//		student2.setBan(banji);
//		student2.setSex("男");
//		
//		Score score = new Score();
//		score.setMath(98);
//		score.setChinese(64);
//		score.setEnglish(88);
//		
//		student2.setScore(score);
//		
//		student.add(student2);
//		banji.setStudents(student);
//		Banji banji2 = new Banji();
//		List<Student> student3 = new ArrayList<Student>();
//		Student student4 = new Student();
//		student4.setName("nicholas");
//		student4.setAge(22);
//		student4.setBan(banji);
//		student4.setSex("男");
//		
//		Score score1 = new Score();
//		score1.setMath(98);
//		score1.setChinese(64);
//		score1.setEnglish(88);
//		
//		student4.setScore(score);
//		
//		student3.add(student2);
//		banji2.setStudents(student3);
//		
//		banjis.add(banji);
//		banjis.add(banji2);
//		Util.saveBanji(banjis);
		
		System.out.println("班级编号：" );
		List<Banji> banjie = Util.getBanjis();
		
		List<Integer> ids = new ArrayList<Integer>();
		for(Banji ban : banjie){
			System.out.println(ban.getId());
			ids.add(ban.getId());
		}
		System.out.println("选择班级：" );
		Scanner scanner = new Scanner(System.in);
		Integer next = scanner.nextInt();
		while(!ids.contains(next)){
			System.out.println("请选择有效班级编号：" );
			next = scanner.nextInt();
		}
		System.out.println("基本操作：\n0:添加班级\n1:删除班级\n2:更新班级");
		int curd = scanner.nextInt();
		while(!(0 <= curd && curd <=2)){
			System.out.println("请输入有效操作：\n0:添加班级\n1:删除班级\n2:更新班级");
			curd = scanner.nextInt();
		}
		switch (curd) {
		case 0:
			//添加班级
			System.out.println("add");
			break;
		case 1:
			//删除班级
			System.out.println("delete");
			
			break;
		case 2:
			//更新班级
			System.out.println("update");
			
			break;

		default:
			break;
		}
	}

}
