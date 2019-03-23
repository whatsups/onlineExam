package com.hp.onlinexam.service.admin;

import java.util.List;

import com.hp.onlinexam.po.Teacher;
/**
 * 专门处理教师管理相关业务
 * @author duye
 *
 */
public interface ITeacherService {
	
	public List<Teacher> findTeachers(String name);
	public void addTeacher(Teacher teacher);
	public void upDateTeacher(Teacher teacher);
	public Teacher getTeacherById(int id);
}
