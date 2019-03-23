package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.vo.TeacherCourseView;

public interface IScheduleService {
	public List<TeacherCourseView> findScheduleByCourseName(String name);
	
	public void addTeacherCourse(TeacherCourse tc);
	
	public void updateTeacherCourse(TeacherCourse tc);
	public void scheduleDelete(int id);
	public TeacherCourse getTeacherCourseById(int id);
}
