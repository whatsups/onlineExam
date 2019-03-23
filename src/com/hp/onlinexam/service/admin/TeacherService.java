package com.hp.onlinexam.service.admin;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexam.dao.admin.ITeacherDao;
import com.hp.onlinexam.dao.admin.TeacherDao;
import com.hp.onlinexam.po.Teacher;

public class TeacherService implements ITeacherService{
	ITeacherDao td = new TeacherDao();

	
	@Override
	public List<Teacher> findTeachers(String name) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list = td.findAllTeachersByInfo(name);
		return list;
	}
	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		td.addTeacher(teacher);
	}
	@Override
	public void upDateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		td.updateTeacherById(teacher);
	}
	@Override
	public Teacher getTeacherById(int id) {
		// TODO Auto-generated method stub
		return td.getTeacherById(id);
	}
}
