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
			System.out.println("�༶��ţ�");
			List<Integer> ids = banjiService.getBanIds(banjiList);
			Scanner scanner = new Scanner(System.in);
			System.out.println("����������\n0:��Ӱ༶\n1:ɾ���༶\n2:���°༶\n3:�˳�����");
			int curd = scanner.nextInt();
			while (!(0 <= curd && curd <= 3)) {
				System.out.println("��������Ч������\n0:��Ӱ༶\n1:ɾ���༶\n2:���°༶\n3:�˳�����");
				curd = scanner.nextInt();
			}
			Integer bId = null;
			switch (curd) {
			case 0:
				// ��Ӱ༶
				if (banjiList.add(new Banji()))
					System.out.println("��ӳɹ�");
				else
					System.out.println("���ʧ��");
				;
				break;
			case 1:
				// ɾ���༶
				System.out.println("ѡ��༶��");
				bId = scanner.nextInt();
				while (!ids.contains(bId)) {// �жϰ༶�Ƿ����
					System.out.println("��ѡ����Ч�༶��ţ�");
					bId = scanner.nextInt();
				}
				banjiService.delete(banjiList, bId);
				break;
			case 2:
				// ���°༶,����ѧ����Ϣ�������
				boolean uBanjiFlag = true;
				while (uBanjiFlag) {
					System.out
							.println("����������\n0:���ѧ����Ϣ\n1:ɾ��ѧ����Ϣ\n2:����ѧ����Ϣ\n3:��ѯѧ����Ϣ\n4:����");
					curd = scanner.nextInt();
					switch (curd) {
					case 0:// ���ѧ����Ϣ
						ids = banjiService.getBanIds(banjiList);
						System.out.println("ѡ��༶��");
						bId = scanner.nextInt();
						while (!ids.contains(bId)) {// �жϰ༶�Ƿ����
							System.out.println("��ѡ����Ч�༶��ţ�");
							bId = scanner.nextInt();
						}
						scanner.nextLine();
						Banji banji = banjiService.get(bId, banjiList);
						System.out.println("��������2-10���ַ���");
						String name = scanner.nextLine().trim();
						while (name.length() < 2 || name.length() > 10) {
							System.out.println("������2-10���ַ�");
							name = scanner.nextLine().trim();
						}
						System.out.println("�Ա𣺣��� �� Ů��");
						String sex = scanner.nextLine().trim();
						while (!(sex.equals("��") || sex.equals("Ů"))) {
							System.out.println("�������� �� Ů");
							sex = scanner.nextLine().trim();
						}
						System.out.println("�������£���yyyy-MM-dd��");
						String birth = scanner.nextLine().trim();
						System.out.println("��ѧ�ɼ���");
						int math = scanner.nextInt();
						System.out.println("Ӣ��ɼ���");
						int english = scanner.nextInt();
						System.out.println("���ĳɼ���");
						int chinese = scanner.nextInt();

						Student student = new Student(name, sex,
								Util.getDate(birth), banji, new Score(math,
										english, chinese));
						if(banjiList.add(banji)){
							System.out.println("��ӳɹ�");
						}else{
							System.out.println("���ʧ��");
						}
						break;
					case 1:// ɾ��ѧ����Ϣ
						banjiService.getBanIds(banjiList);
						System.out.println("ѡ��༶��");
						bId = scanner.nextInt();
						while (!ids.contains(bId)) {// �жϰ༶�Ƿ����
							System.out.println("��ѡ����Ч�༶��ţ�");
							bId = scanner.nextInt();
						}
						scanner.nextLine();
						System.out.println("����ѧ������");
						
						String stuName = scanner.nextLine().trim();
						if(studentService.get(bId, stuName, banjiList) == null){
							System.out.println("������������");
							break;
						}
						studentService.delete(bId, stuName, banjiList);
						break;
					case 2:// ����ѧ����Ϣ
						//��ʾ���а༶�ı��
						/*
						 * ������Ҫ���µ�ѧ�����ڵİ༶���
						 * �ٻ�ȡ���������а༶�ı�ţ������¼���
						 * ���жϰ༶��ŵļ������Ƿ��������İ༶
						 * �۲������������ʾ��Ϣ������ʾ�û�����
						 * ��ѭ���ڣ���
						 */
						ids = banjiService.getBanIds(banjiList);
						System.out.println("ѡ��༶��");
						bId = scanner.nextInt();
						while (!ids.contains(bId)) {// �жϰ༶�Ƿ����
							System.out.println("��ѡ����Ч�༶��ţ�");
							bId = scanner.nextInt();
						}
						scanner.nextLine();
						/*
						 * nextInt()ֻ�������֣�������س����� ��������Ϊ���ּ�/r/n,
						 * ��ʱ����nextLine(),���ȡ��/r/n,�ʷ��ؿ��ַ���,
						 * ׷��һ��nextLine(),��������ǰ�С�
						 */
						/*
						 * ������Ҫ���µ�ѧ������
						 * �ٴ�ָ���༶��ѧ�������в�ѯ��ѧ�������Ƿ����
						 * �ڲ����ڸ�����ʾ��Ϣ������ʾ��������
						 * ���ظ��٣���
						 * �ܴ��ڣ���ȡ��ѧ������
						 */
						System.out.println("����ѧ������");
						stuName = scanner.nextLine().trim();
						Student student3 = studentService.get(bId, stuName, banjiList);
						if(student3 != null){
							System.out.println(student3);
							banji = banjiService.get(bId, banjiList);
							System.out.println("��������2-10���ַ���");
							name = scanner.nextLine().trim();
							while (name.length() < 2 || name.length() > 10) {
								System.out.println("������2-10���ַ�");
								name = scanner.nextLine().trim();
							}
							System.out.println("�Ա𣺣��� �� Ů��");
							sex = scanner.nextLine().trim();
							while (!(sex.equals("��") || sex.equals("Ů"))) {
								System.out.println("�������� �� Ů");
								sex = scanner.nextLine().trim();
							}
							System.out.println("�������£���yyyy-MM-dd��");
							birth = scanner.nextLine().trim();
							System.out.println("��ѧ�ɼ���");
							math = scanner.nextInt();
							System.out.println("Ӣ��ɼ���");
							english = scanner.nextInt();
							System.out.println("���ĳɼ���");
							chinese = scanner.nextInt();

							student3.setName(name);
							student3.setSex(sex);
							student3.setScore(new Score(math,english,chinese));
							student3.setBirth(Util.getDate(birth));
							student3.setBan(banji);
							if(studentService.update(student3, banji)){
								System.out.println("��ӳɹ�");
							}else{
								System.out.println("���ʧ��");
							}
						}
						else
							System.out.println("������������");
						//�����ֶ�
						
						break;
					case 3:// ��ѯѧ����Ϣ
						System.out.println("�����ѯ�༶��ţ�");
						bId = scanner.nextInt();
						while (!ids.contains(bId)) {// �жϰ༶�Ƿ����
							System.out.println("��ѡ����Ч�༶��ţ�");
							bId = scanner.nextInt();
						}
						scanner.nextLine().trim();
						System.out.println("�������ѯ����:");
						stuName = scanner.nextLine().trim();
						Student student2 = studentService.get(bId, stuName, banjiList) ;
						if(student2 != null)
							System.out.println(student2);
						else
							System.out.println("������������");
						break;
					case 4:
						uBanjiFlag = false;
						break;
					default:
						break;
					}
				}
				break;
			case 3:// �˳�����
				flag = false;
				break;
			default:
				break;
			}
		}
		Util.saveBanjiList(banjiList);
	}

}
