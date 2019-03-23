package com.hp.onlinexam.dao.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;

public interface ITestDao {
	public List<Course> findCoursesByTeacherId(int id);
	public List<StuClass> findStuClassesByTeacherId(int id );

	public String findStuClassNamesByIds(String ids);
	
	public void addTest(Test t);
	public List<Map<String,Object>> findAllTest(Teacher t);
	
	public Map<String,Object> findtestById(int id);
	
	public List<Map<String,Object>> findQuestionsByTestId(int testId);
	public List<Map<String,Object>> getTestByStudent(int id,String currData);
	public Map<String, Object> findStudentTestsById(int studentid,int testid) ;

}
