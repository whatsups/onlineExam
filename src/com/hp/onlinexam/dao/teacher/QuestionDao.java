package com.hp.onlinexam.dao.teacher;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.util.DBUtil;

public class QuestionDao implements IQuestionDao{
	private DBUtil db = new DBUtil();
	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		// TODO Auto-generated method stub
		String sql = "select q.*,c.name as name from questions q,course c where c.id = q.courseId ";
		if (null != key){
			try {
				key = new String(key.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		if(key!=null){
			if("name".equals(key)){
				sql ="select q.*,c.name as name from questions q,course c where c.id = q.courseId and c.`name` like '%"+value+"%'";
			}else if("queTitle".equals(key)){
				sql ="select q.*,c.name as name from questions q,course c where c.id = q.courseId and q.queTitle like '%"+value+"%'";
			}
		}
		sql += " and pointId = 1";
		List queList = new ArrayList();
		try {
			queList = db.getQueryList(sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		String sql = "insert into questions(courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans,pointId) values(?,?,?,?,?,?,?,?,1)";
		try {
			db.execute(sql, new Object[]{q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from questions  where id = "+id+"  and pointId = 1";
		Map<String ,Object> qmap  = new HashMap<String,Object>();
		try {
			qmap = db.getObject(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qmap;
	}
	
	


	@Override
	public void updateQuestionInfo(Question q) {
		String sql = "update questions set courseId = ?,queType=?,queTitle=?,choiceA=?,choiceB=?,choiceC=?,choiceD=?,ans = ?,pointId= 1 "
				+ "where id = ?";
		try {
			db.execute(sql, new Object[]{q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),q.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		IQuestionDao qd = new QuestionDao();
		Map m = new HashMap();
		m = qd.findQuestionById(1);
		Set<String> set = m.keySet();
		for(String s:set){
			System.out.println(s+"---"+m.get(s));
		}
	}

	@Override
	public void deleteQueInfo(int id) {
		// TODO Auto-generated method stub
		String sql ="update questions set pointId = 2 where id = "+id;
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据课程名称提取试题
	 * 
	 * @param courseId
	 * @return
	 */
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId){
		String sql = "select * from questions where courseId = ? order by id desc";
		List<Map<String,Object>> queList = new ArrayList<Map<String,Object>>();
		try {
			queList = db.getQueryList(sql, new Object[]{courseId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return queList;
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		String sql ="select * from questions where FIND_IN_SET (id,?)";
		List l = new ArrayList();
		try {
			l = db.getQueryList(Question.class, sql, new Object[]{ids});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(l == null){
			l = new ArrayList();
		}
		return l;
	}

}
