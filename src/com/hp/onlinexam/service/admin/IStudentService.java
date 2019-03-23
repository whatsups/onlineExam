package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Student;

public interface IStudentService {
	public List<Map<String,Object>> findStudent(String stuname);
	
	public void addStudent(Student s);
	
	public void updateStudentInfo(Student s);
	
	public Student findStudentById(int id);
}
