package com.zc.basic_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.zc.service.BanjiService;
import com.zc.service.StudentService;
import com.zc.service.impl.BanjiServiceImpl;
import com.zc.service.impl.StudentServiceImpl;


@SuppressWarnings("resource")
public class Test {
	static BanjiService banjiService = new BanjiServiceImpl();
	static StudentService studentService = new StudentServiceImpl();
	public static void main(String[] args) {
		//Util.initData();
		
		List<Banji> banjiList = Util.getBanjiList();
		
		boolean flag = true;
		while (flag) {
			System.out.println("班级编号：");
			List<Integer> ids = banjiService.getBanIds(banjiList);
			Scanner scanner = new Scanner(System.in);
			System.out.println("基本操作：\n0:添加班级\n1:删除班级\n2:更新班级\n3:退出程序");
			int curd = scanner.nextInt();
			while (!(0 <= curd && curd <= 3)) {
				System.out.println("请输入有效操作：\n0:添加班级\n1:删除班级\n2:更新班级\n3:退出程序");
				curd = scanner.nextInt();
			}
			Integer bId = null;
			switch (curd) {
			case 0:
				// 添加班级
				if (banjiList.add(new Banji()))
					System.out.println("添加成功");
				else
					System.out.println("添加失败");
				;
				break;
			case 1:
				// 删除班级
				System.out.println("选择班级：");
				bId = scanner.nextInt();
				while (!ids.contains(bId)) {// 判断班级是否存在
					System.out.println("请选择有效班级编号：");
					bId = scanner.nextInt();
				}
				banjiService.delete(banjiList, bId);
				break;
			case 2:
				// 更新班级,进入学生信息管理界面
				boolean uBanjiFlag = true;
				while (uBanjiFlag) {
					System.out
							.println("基本操作：\n0:添加学生信息\n1:删除学生信息\n2:更新学生信息\n3:查询学生信息\n4:返回");
					curd = scanner.nextInt();
					switch (curd) {
					case 0:// 添加学生信息
						ids = banjiService.getBanIds(banjiList);
						System.out.println("选择班级：");
						bId = scanner.nextInt();
						while (!ids.contains(bId)) {// 判断班级是否存在
							System.out.println("请选择有效班级编号：");
							bId = scanner.nextInt();
						}
						scanner.nextLine();
						Banji banji = banjiService.get(bId, banjiList);
						System.out.println("姓名：（2-10个字符）");
						String name = scanner.nextLine().trim();
						while (name.length() < 2 || name.length() > 10) {
							System.out.println("请输入2-10个字符");
							name = scanner.nextLine().trim();
						}
						System.out.println("性别：（男 或 女）");
						String sex = scanner.nextLine().trim();
						while (!(sex.equals("男") || sex.equals("女"))) {
							System.out.println("请输入男 或 女");
							sex = scanner.nextLine().trim();
						}
						System.out.println("出生年月：（yyyy-MM-dd）");
						String birth = scanner.nextLine().trim();
						System.out.println("数学成绩：");
						int math = scanner.nextInt();
						System.out.println("英语成绩：");
						int english = scanner.nextInt();
						System.out.println("语文成绩：");
						int chinese = scanner.nextInt();

						Student student = new Student(name, sex,
								Util.getDate(birth), banji, new Score(math,
										english, chinese));
						if(banjiList.add(banji)){
							System.out.println("添加成功");
						}else{
							System.out.println("添加失败");
						}
						break;
					case 1:// 删除学生信息
						banjiService.getBanIds(banjiList);
						System.out.println("选择班级：");
						bId = scanner.nextInt();
						while (!ids.contains(bId)) {// 判断班级是否存在
							System.out.println("请选择有效班级编号：");
							bId = scanner.nextInt();
						}
						scanner.nextLine();
						System.out.println("输入学生姓名");
						
						String stuName = scanner.nextLine().trim();
						if(studentService.get(bId, stuName, banjiList) == null){
							System.out.println("该姓名不存在");
							break;
						}
						studentService.delete(bId, stuName, banjiList);
						break;
					case 2:// 更新学生信息
						//显示所有班级的编号
						/*
						 * 输入需要更新的学生所在的班级编号
						 * ①获取集合中所有班级的编号，存入新集合
						 * ②判断班级编号的集合中是否包含输入的班级
						 * ③不存在则给出提示信息，并提示用户输入
						 * ④循环②，③
						 */
						ids = banjiService.getBanIds(banjiList);
						System.out.println("选择班级：");
						bId = scanner.nextInt();
						while (!ids.contains(bId)) {// 判断班级是否存在
							System.out.println("请选择有效班级编号：");
							bId = scanner.nextInt();
						}
						scanner.nextLine();
						/*
						 * nextInt()只读出数字，当输入回车符是 该行内容为数字加/r/n,
						 * 此时再用nextLine(),会读取到/r/n,故返回空字符串,
						 * 追加一个nextLine(),可跳过当前行。
						 */
						/*
						 * 输入需要更新的学生姓名
						 * ①从指定班级的学生集合中查询该学生姓名是否存在
						 * ②不存在给出提示信息，并提示重新输入
						 * ③重复①，②
						 * ④存在，获取该学生对象
						 */
						System.out.println("输入学生姓名");
						stuName = scanner.nextLine().trim();
						Student student3 = studentService.get(bId, stuName, banjiList);
						if(student3 != null){
							System.out.println(student3);
							banji = banjiService.get(bId, banjiList);
							System.out.println("姓名：（2-10个字符）");
							name = scanner.nextLine().trim();
							while (name.length() < 2 || name.length() > 10) {
								System.out.println("请输入2-10个字符");
								name = scanner.nextLine().trim();
							}
							System.out.println("性别：（男 或 女）");
							sex = scanner.nextLine().trim();
							while (!(sex.equals("男") || sex.equals("女"))) {
								System.out.println("请输入男 或 女");
								sex = scanner.nextLine().trim();
							}
							System.out.println("出生年月：（yyyy-MM-dd）");
							birth = scanner.nextLine().trim();
							System.out.println("数学成绩：");
							math = scanner.nextInt();
							System.out.println("英语成绩：");
							english = scanner.nextInt();
							System.out.println("语文成绩：");
							chinese = scanner.nextInt();

							student3.setName(name);
							student3.setSex(sex);
							student3.setScore(new Score(math,english,chinese));
							student3.setBirth(Util.getDate(birth));
							student3.setBan(banji);
							if(studentService.update(student3, banji)){
								System.out.println("添加成功");
							}else{
								System.out.println("添加失败");
							}
						}
						else
							System.out.println("该姓名不存在");
						//更新字段
						
						break;
					case 3:// 查询学生信息
						System.out.println("输入查询班级编号：");
						bId = scanner.nextInt();
						while (!ids.contains(bId)) {// 判断班级是否存在
							System.out.println("请选择有效班级编号：");
							bId = scanner.nextInt();
						}
						scanner.nextLine().trim();
						System.out.println("请输入查询姓名:");
						stuName = scanner.nextLine().trim();
						Student student2 = studentService.get(bId, stuName, banjiList) ;
						if(student2 != null)
							System.out.println(student2);
						else
							System.out.println("该姓名不存在");
						break;
					case 4:
						uBanjiFlag = false;
						break;
					default:
						break;
					}
				}
				break;
			case 3:// 退出程序
				flag = false;
				break;
			default:
				break;
			}
		}
		Util.saveBanjiList(banjiList);
	}

}
