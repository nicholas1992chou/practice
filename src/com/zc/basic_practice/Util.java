package com.zc.basic_practice;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


;

public class Util {
	private static final String PATH = "banji.txt";

	@SuppressWarnings("unchecked")
	public static List<Banji> getBanjis() {
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
	public static boolean saveBanji(List<Banji> banji){
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
}
