package com.hp.onlinexam.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.IStudentDao;
import com.hp.onlinexam.dao.admin.StudentDao;
import com.hp.onlinexam.po.Student;

public class StudentService implements IStudentService{
	IStudentDao sd = new StudentDao();
	@Override
	public List<Map<String,Object>> findStudent(String stuname) {
		// TODO Auto-generated method stub
		
		return sd.findStudentByName(stuname);
	}

	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		sd.addStudent(s);
	}

	@Override
	public void updateStudentInfo(Student s) {
		sd.updateStudent(s);
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return sd.findStudentById(id);
	}
	
}
