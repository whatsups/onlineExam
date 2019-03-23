package com.hp.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.ITestDao;
import com.hp.onlinexam.dao.teacher.TestDao;
import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;

public class TestService implements ITestService{
	ITestDao qd = new TestDao();
	@Override
	public List<Course> findCourseByTeacherId(int id) {
		// TODO Auto-generated method stub
		return qd.findCoursesByTeacherId(id);
	}
	@Override
	public List<StuClass> findStuClassByTeacherId(int id) {
		// TODO Auto-generated method stub
		return qd.findStuClassesByTeacherId(id);
	}
	@Override
	public String findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		return qd.findStuClassNamesByIds(ids);
	}
	@Override
	public void addTest(Test t) {
		// TODO Auto-generated method stub
		qd.addTest(t);
	}
	@Override
	public List<Map<String,Object>> findAllTest(Teacher t) {
		// TODO Auto-generated method stub
		return qd.findAllTest(t);
	}
	@Override
	public Map<String, Object> findTestById(int id) {
		// TODO Auto-generated method stub
		return qd.findtestById(id);
	}
	@Override
	public List<Map<String, Object>> findQuestionsByTestId(int testId) {
		// TODO Auto-generated method stub
		return qd.findQuestionsByTestId(testId);
	}
	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		return qd.getTestByStudent(id, currData);
	}
	/**
	 * 根据学生id号和试卷编号查询试卷信息
	 */
	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		return qd.findStudentTestsById(studentid, testid);
	}

	
}
