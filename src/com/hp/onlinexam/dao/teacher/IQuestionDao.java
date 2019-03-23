package com.hp.onlinexam.dao.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.StuClass;

public interface IQuestionDao {
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value);

	public void addQuestion(Question q);

	public Map<String, Object> findQuestionById(int id);

	public void updateQuestionInfo(Question q);
	
	public void deleteQueInfo(int id);
	/**
	 * 根据课程名称提取试题ID
	 * 
	 * @param courseId
	 * @return
	 */
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId);
	public List<Question> findQuestionByIds(String ids) ;

	
}
