package com.hp.onlinexam.dao.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Student;

public interface IStudentDao {
	public List<Map<String,Object>> findStudentByName(String stuname);
	
	public void addStudent(Student s);
	
	public void updateStudent(Student s);
	
	public Student findStudentById(int id);
}
