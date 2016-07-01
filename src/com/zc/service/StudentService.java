package com.zc.service;

import java.util.List;

import com.zc.beans.Banji;
import com.zc.beans.Student;

public interface StudentService{
	void delete(Integer bId, String name, List<Banji> banjiList);
	Student get(Integer id, String name, List<Banji> banjiList);
	boolean update(Student student, Banji banji);
}
