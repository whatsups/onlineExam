package com.hp.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.StuClass;

public interface IQuestionService {
	public List<Map<String,Object>> findAll(String key, String value);
	public void addQuestion(Question q);
	public Map<String, Object> findQuestionById(int id);
	public void updateQue(Question q);
	public void deleteQue(int id);
	public List<Map<String, Object>> collectQuestions(int courseId,int num);
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId);
	/**
	 * 通过给定的question的集合获得集合里的question的id号
	 * 组成一个string类型的字符串，并且id之间以逗号隔开
	 * @param list
	 * @return
	 */
	public String getQueIdsByQueList(List<Map<String,Object>> queList);
	
	public List<Question> findQuestionByIds(String ids) ;

}
