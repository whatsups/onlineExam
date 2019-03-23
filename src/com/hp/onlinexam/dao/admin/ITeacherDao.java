package com.hp.onlinexam.dao.admin;

import java.util.List;

import com.hp.onlinexam.po.Teacher;

public interface ITeacherDao {
	
	/**
	 * 通过姓名查询符合条件的教师对象
	 * name 是教师名字
	 * 支持模糊查询
	 * 如果name是null表示查询所有
	 * @param name
	 * @return
	 */
	public List<Teacher> findAllTeachersByInfo(String name);
	public void addTeacher(Teacher teacher);
	public void updateTeacherById(Teacher teacher);
	public Teacher getTeacherById(int id);
}
