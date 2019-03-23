package com.hp.onlinexam.service.teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.IQuestionDao;
import com.hp.onlinexam.dao.teacher.QuestionDao;
import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.StuClass;
/**
 * 提供了试题相关的业务
 * @author duye
 *
 */
public class QuestionService implements IQuestionService{
	private IQuestionDao qd = new QuestionDao();
	@Override
	public List<Map<String, Object>> findAll(String key, String value) {
		// TODO Auto-generated method stub
		return qd.findAllQuestionInfo(key, value);
	}
	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		qd.addQuestion(q);
	}
	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		
		return qd.findQuestionById(id);
	}
	@Override
	public void updateQue(Question q) {
		// TODO Auto-generated method stub
		qd.updateQuestionInfo(q);
	}
	@Override
	public void deleteQue(int  id) {
		// TODO Auto-generated method stub
		qd.deleteQueInfo(id);
	}
	/**
	 * 根据课程名称和试题数量获得所需试题
	 * @param courseId 课程名称
	 * @param num 试题数量
	 * @return 返回试题的集合
	 */

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num) {
		// TODO Auto-generated method stub
		
		List<Map<String,Object>> queList = new ArrayList<Map<String,Object>>();
		queList= qd.findQuestionsByCourseId(courseId);
		if(queList == null){
			return new ArrayList<Map<String,Object>>();
		}
		Collections.shuffle(queList);
		if(queList.size()<=num){
			/**
			 * 试题不够直接全部返回
			 */
			return queList;
		}
		List<Map<String,Object>> newQueList = new ArrayList<Map<String,Object>>();
		
		for(int i = 0;i<num;i++){
			newQueList.add(queList.get(i));
		}
		return newQueList;
	}
	/**
	 * 根据课程名称提取试题ID
	 * 
	 * @param courseId
	 * @return
	 */

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return qd.findQuestionsByCourseId(courseId);
	}
	
	/**
	 * 通过给定的question的集合获得集合里的question的id号
	 * 组成一个string类型的字符串，并且id之间以逗号隔开
	 * @param list
	 * @return String:题目id们的字符串
	 */
	@Override
	public String getQueIdsByQueList(List<Map<String, Object>> queList) {
		// TODO Auto-generated method stub
		if(null ==queList || queList.size()<1){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<queList.size();i++){
			if(i == queList.size()-1){
				sb.append(queList.get(i).get("id"));
			}else{
				sb.append(queList.get(i).get("id")).append(",");
			}
		}
		return sb.toString();
	}
	
	public List<Question> findQuestionByIds(String ids) {
		return qd.findQuestionByIds(ids);
	}
}
