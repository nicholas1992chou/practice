package com.zc.basic_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//Util.initData();
		List<Banji> banjiList = Util.getBanjiList();
		boolean flag = true;
		while (flag) {
			System.out.println("�༶��ţ�");
			List<Integer> ids = null;
			if (banjiList != null) {
				ids = new ArrayList<Integer>();
				System.out.println("---------------------");
				for (Banji banji : banjiList) {
					// System.out.println(banji.getId());
					System.out.println(banji);
					ids.add(banji.getId());
					System.out.println("---------------------");
				}
			}
			Scanner scanner = new Scanner(System.in);

			System.out.println("����������\n0:��Ӱ༶\n1:ɾ���༶\n2:���°༶\n3:�˳�����");
			int curd = scanner.nextInt();
			while (!(0 <= curd && curd <= 2)) {
				System.out.println("��������Ч������\n0:��Ӱ༶\n1:ɾ���༶\n2:���°༶");
				curd = scanner.nextInt();
			}
			Integer bId = null;
			switch (curd) {
			case 0:
				// ��Ӱ༶
				banjiList.add(new Banji());

				if (Util.saveBanjiList(banjiList))
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
				boolean Searchflag = false;
				
				for (Banji banji : banjiList) {
					if (banji.getId().equals(bId)) {// ʹ�ð�װ��Ƚ���ֵ��ȣ���equals
						banjiList.remove(banji);
						Searchflag = true;
						break;
					}
				}
				if (Searchflag) {
					Util.saveBanjiList(banjiList);
					System.out.println("ɾ���ɹ�");
				} else
					System.out.println("ɾ��ʧ��");
				break;
			case 2:
				// ���°༶,����ѧ����Ϣ�������
				boolean updateFlag = true;
				while (updateFlag) {
					System.out
							.println("����������\n0:���ѧ����Ϣ\n1:ɾ��ѧ����Ϣ\n2:����ѧ����Ϣ\n3:��ѯѧ����Ϣ\n4:����");
					curd = scanner.nextInt();
					switch (curd) {
					case 0:// ���ѧ����Ϣ
						if (banjiList != null) {
							ids = new ArrayList<Integer>();
							for (Banji banji : banjiList) {
								System.out.println(banji.getId());
								ids.add(banji.getId());
							}
						}
						System.out.println("ѡ��༶��");
						bId = scanner.nextInt();
						while (!ids.contains(bId)) {// �жϰ༶�Ƿ����
							System.out.println("��ѡ����Ч�༶��ţ�");
							bId = scanner.nextInt();
						}
						scanner.nextLine();
						Banji banji = null;
						for (Banji ban : banjiList) {
							if (ban.getId().equals(bId)) {
								banji = ban;
								break;
							}
						}
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
						if (banjiList != null) {
							ids = new ArrayList<Integer>();
							for (Banji banji2 : banjiList) {
								System.out.println(banji2.getId());
								ids.add(banji2.getId());
							}
						}
						System.out.println("ѡ��༶��");
						bId = scanner.nextInt();
						while (!ids.contains(bId)) {// �жϰ༶�Ƿ����
							System.out.println("��ѡ����Ч�༶��ţ�");
							bId = scanner.nextInt();
						}
						scanner.nextLine();
						System.out.println("����ѧ������");
						String stuName = scanner.nextLine().trim();
						boolean delStuFlag = false;
						for (Banji banji2 : banjiList) {

							if (banji2.getId().equals(bId)) {
								for (Student student2 : banji2.getStudents()) {
									if (student2.getName().equals(stuName)) {
										banji2.getStudents().remove(student2);
										delStuFlag = true;
										break;
									}
								}
								break;
							}
						}
						if(delStuFlag)
							System.out.println("ɾ���ɹ�");
						else
							System.out.println("ɾ��ʧ��");
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
						
						//�����ֶ�
						System.out.println();
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
						if(!banjiList.isEmpty()){
							for (Banji banji2 : banjiList) {
								if (banji2.getId().equals(bId)) {
									for (Student student2 : banji2.getStudents()) {
										if (student2.getName().contains(stuName)) {
											System.out.println(student2);
										}
									}
									break;
								}
							}
						}else{
							System.out.println("��ǰ���κ���Ϣ");
						}
						
						break;
					case 4:
						updateFlag = false;
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
