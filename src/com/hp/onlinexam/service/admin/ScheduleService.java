package com.hp.onlinexam.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.IScheduleDao;
import com.hp.onlinexam.dao.admin.ScheduleDao;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.vo.TeacherCourseView;

public class ScheduleService implements IScheduleService {
	IScheduleDao  sd = new ScheduleDao();
	@Override
	public List<TeacherCourseView> findScheduleByCourseName(String name) {
		// TODO Auto-generated method stub
		List tcList = new ArrayList<Map<String,String>>();
		tcList = sd.findScheduleByCourseName(name);
		return tcList;
	}
	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		sd.addTeacherCourse(tc);
	}
	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		sd.updateTeacherCourse(tc);
	}
	@Override
	public void scheduleDelete(int id) {
		// TODO Auto-generated method stub
		sd.scheduleDelete(id);
	}
	@Override
	public TeacherCourse getTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return sd.getTeacherCourseById(id);
	}

}
