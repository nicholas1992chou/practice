package com.zc.service;

import java.util.List;

import com.zc.basic_practice.Banji;
import com.zc.basic_practice.Student;

public interface StudentService{
	void delete(Integer bId, String name, List<Banji> banjiList);
	Student get(Integer id, String name, List<Banji> banjiList);
	boolean update(Student student, Banji banji);
}
