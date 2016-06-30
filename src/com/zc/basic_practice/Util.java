package com.zc.basic_practice;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Util {
	private static final String PATH = "banji.txt";

	@SuppressWarnings("unchecked")
	public static List<Banji> getBanjiList() {
		List<Banji> list = new ArrayList<Banji>();
		ObjectInputStream objectInputStream = null;
		
		try {
			objectInputStream = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(PATH)));
			
			list = (List<Banji>) objectInputStream.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				objectInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public static boolean saveBanjiList(List<Banji> banji){
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(PATH)));
			objectOutputStream.writeObject(banji);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				if(objectOutputStream != null)
					objectOutputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static boolean initData(){
		List<Banji> banjiList = new ArrayList<>();
		List<Student> students = new ArrayList<>();
		Banji banji1 = new Banji();
		Student student1 = new Student("s1", "ÄÐ", getDate("1992-11-20"), banji1, new Score(77, 88, 99));
		Student student2 = new Student("s2", "ÄÐ", getDate("1992-11-12"), banji1, new Score(72, 82, 91));
		Student student3 = new Student("s3", "ÄÐ", getDate("1990-11-20"), banji1, new Score(77, 88, 99));
		Student student4 = new Student("s4", "ÄÐ", getDate("1992-10-12"), banji1, new Score(72, 82, 91));
		Student student5 = new Student("s5", "ÄÐ", getDate("1991-11-20"), banji1, new Score(77, 88, 99));
		Student student6 = new Student("s6", "ÄÐ", getDate("1992-11-12"), banji1, new Score(72, 82, 91));
		Student student7 = new Student("s7", "ÄÐ", getDate("1992-11-20"), banji1, new Score(77, 88, 99));
		Student student8 = new Student("s8", "ÄÐ", getDate("1992-6-12"), banji1, new Score(72, 82, 91));
		Student student9 = new Student("s9", "ÄÐ", getDate("1992-11-20"), banji1, new Score(47, 88, 99));
		Student student10 = new Student("s10", "Å®", getDate("1988-12-12"), banji1, new Score(32, 82, 91));
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);
		students.add(student7);
		students.add(student8);
		students.add(student9);
		students.add(student10);
		
		banji1.setStudents(students);
		
		banjiList.add(banji1);
		
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(PATH)));
			objectOutputStream.writeObject(banjiList);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			if(objectOutputStream != null){
				try {
					objectOutputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	public static Date getDate(String dateStr){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static boolean fileExists(){
		return (new File(PATH)).exists();
	}
}
