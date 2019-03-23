package com.hp.onlinexam.dao.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.vo.TeacherCourseView;

public interface IScheduleDao {
	public List<TeacherCourseView> findScheduleByCourseName(String name);
	/**
	 * 添加TeacherCourse对象， 这个对象描述了老师、课程的关系
	 * @param tc
	 */
	public void addTeacherCourse(TeacherCourse tc);
	
	public void updateTeacherCourse(TeacherCourse tc);
	
	public void scheduleDelete(int scheduleId);
	
	public TeacherCourse getTeacherCourseById(int id);
}
