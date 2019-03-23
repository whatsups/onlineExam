package com.hp.onlinexam.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.CourseDao;
import com.hp.onlinexam.dao.admin.ICourseDao;
import com.hp.onlinexam.po.Course;

public class CourseService implements ICourseService{
	private ICourseDao cd = new CourseDao();
	@Override
	public List<Course> findAllCourses(String name) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list = cd.findAllCourses(name);
		return list;
	}
	@Override
	public void addCourseByName(String name) {
		// TODO Auto-generated method stub
		cd.addCourseByName(name);
	}
	@Override
	public void updateCourse(Course c) {
		// TODO Auto-generated method stub
		cd.updateCourseById(c);
	}
	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		return cd.findCourseById(id);
	}
	@Override
	public String findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		return cd.findClassNamesByIds(ids);
	}
	@Override
	public List<Map<String,Object>> findCoursesByTeacherId(int id) {
		// TODO Auto-generated method stub
		return cd.findCoursesByTeacherId(id);
	}

}
