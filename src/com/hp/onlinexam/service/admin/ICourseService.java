package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;

public interface ICourseService {
	public List<Course> findAllCourses(String name);
	public void addCourseByName(String name);
	public void updateCourse(Course c);
	public Course findCourseById(int id);
	public String findClassNamesByIds(String ids);
	public List<Map<String,Object>> findCoursesByTeacherId(int id);
}
