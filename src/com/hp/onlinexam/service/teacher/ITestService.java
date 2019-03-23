package com.hp.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;

public interface ITestService {
	public List<Course> findCourseByTeacherId(int id);
	public List<StuClass> findStuClassByTeacherId(int id);
	public String findClassNamesByIds(String ids);

	public void addTest(Test t);
	public List<Map<String,Object>> findAllTest(Teacher t);
	
	public Map<String,Object> findTestById(int id);
	
	public List<Map<String,Object>> findQuestionsByTestId(int testId);
	
	public List<Map<String, Object>> getTestByStudent(int id, String currData);

	public Map<String, Object> findStudentTestsById(int studentid,int testid) ;

}
