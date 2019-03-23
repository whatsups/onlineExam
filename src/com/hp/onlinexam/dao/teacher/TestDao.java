package com.hp.onlinexam.dao.teacher;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.util.ToolUtil;

public class TestDao implements ITestDao{
	private DBUtil db = new DBUtil();
	/**
	 * 获取这个老师教的所有课程
	 */
	@Override
	public List<Course> findCoursesByTeacherId(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from course where id in (SELECT courseId from teachercourse "
				+ "where teaId = "+ id+")";
		List list  = new ArrayList();
		try {
			list = db.getQueryList(Course.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == list){
			list = new ArrayList();
		}
		return list;
	}
	/**
	 * 获取这个老师的班级
	 */
	@Override
	public List<StuClass> findStuClassesByTeacherId(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from stuclass where id in (SELECT classId from teachercourse where teaId = ?)";
		List stuClassList= new ArrayList();
		try {
			stuClassList = db.getQueryList(StuClass.class, sql, new Object[]{id});
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == stuClassList)
			stuClassList = new ArrayList();
		return stuClassList;
	}
	@Override
	public String findStuClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		String sql = "SELECT name from stuclass where id in ("+ids+")";
		List<Map<String,Object>> nameList = new ArrayList<Map<String,Object>>();
		try {
			nameList = db.getQueryList(sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null == nameList){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<nameList.size();i++){
			sb.append(nameList.get(i).get("name")).append(" ");
			
		}
		return sb.toString();
	}
	@Override
	public void addTest(Test t) {
		// TODO Auto-generated method stub
		String sql = "insert into test(name,courseId,endDate,questions,teacherId,classIds,testTime,scores) "
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{t.getName(),t.getCourseId(),t.getEndDate(),t.getQuestons(),t.getTeacherId(),t.getClassIds(),t.getTestTime(),t.getScores()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 找到没有截止所有考试
	 * 并且这些考试必须是所登录的老师所出的
	 */
	@Override
	public List<Map<String,Object>> findAllTest(Teacher t) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
//		String sql ="select t.* ,c.name courseName, sc.name classNames  from test t,course c ,stuclass sc"
//				+ " where t.courseId = c.id  and sc.id in (t.classIds)  order by t.endDate desc";
		String sql ="select t.*,c.name  courseName "
				+ "from( SELECT t.courseId cid,t.id,t.scores,t.testTime,t.endDate,t.`name`, (SELECT GROUP_CONCAT(c.name ) "
				+ "FROM stuclass c WHERE FIND_IN_SET(c.id,t.classIds))classNames FROM test t "
				+ "where  t.teacherId= "+t.getId()+" )as t join course c on t.cid=c.id order by t.endDate"; 

		try {
			list = db.getQueryList(sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List newList = new ArrayList();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		for(int i = 0;i<list.size();i++){
			Map<String,Object> map = (Map<String, Object>) list.get(i);
			Timestamp endTime = (Timestamp) map.get("endDate");
			if(ts.before(endTime)){
				newList.add(list.get(i));
			}
		}
		if(newList == null){
			newList = new ArrayList();
		}
	
		return newList;
	}
	

	@Override
	public Map<String,Object> findtestById(int id) {
		// TODO Auto-generated method stub
		//还要拿到questionList
		String sql = "select t.name tName,t.endDate endDate,t.testTime testTime,c.name cName,GROUP_CONCAT(sc.name) className "
				+ "from test t,course c,stuclass sc where t.id = "+id+" and FIND_IN_SET(sc.id,t.classIds) "
						+ "and c.id = t.courseId";
		
		Map<String,Object> map  = new HashMap<String,Object>();
		try {
			map = db.getObject(sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(map == null){
			map = new HashMap<String,Object>();
		}
		return map;
	}
	@Override
	public List<Map<String, Object>> findQuestionsByTestId(int testId) {
		// TODO Auto-generated method stub
		IQuestionDao qd = new QuestionDao();
		List<Map<String,Object>> queList = new ArrayList<Map<String, Object>>();
		String sql = "select * from test where id = "+testId;
		//Test tNow = new Test();
		Map<String,Object> tmap = new HashMap();
		try {
			tmap = db.getObject(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String queIds = (String) tmap.get("questions");
		String sql2 = "select * from questions where id in ("+queIds+")";
		try {
			queList = db.getQueryList(sql2, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queList;
	}
	
	
	public static void main(String[] args) {
		ITestDao td = new TestDao();
		DBUtil db = new DBUtil();
//		String n = "123";
//		String name = td.findStuClassNamesByIds(n);
//		System.out.println(name);
//		List<Map<String, Object>>  l = td.findQuestionsByTestId(1);
//		System.out.println(l.size());
//		DBUtil db = new DBUtil();
//		IQuestionDao qd = new QuestionDao();
//		List<Map<String,Object>> queList = new ArrayList<Map<String, Object>>();
//		String sql = "select * from test where id = "+"1";
//		Map<String,Object> mapMy = new HashMap();
//		try {
//			mapMy = db.getObject(sql);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				
//		System.out.println(mapMy.get("id"));
//		System.out.println(mapMy.get("questions"));
//		for(int i = 0;i<queIds.length();i++){
//			char a = queIds.charAt(i);
//			if(a!=','){
//				queList.add(qd.findQuestionById(a));
//			}
//		}
//		if(queList == null){
//			queList = new ArrayList<Map<String, Object>>();
//		}
	//System.out.println(queList.size());
		
//		
//		List l = td.findQuestionsByTestId(8);
//		System.out.println(l.size());
//		for(int i = 0;i<l.size();i++){
//			Map  m = (Map)l.get(i);
//			System.out.println(m.get("queTitle"));
//		}
//		
//		
		
//		IQuestionDao qd = new QuestionDao();
//		List<Map<String,Object>> queList = new ArrayList<Map<String, Object>>();
//		String sql = "select * from test where id = "+8;
//		//Test tNow = new Test();
//		Map<String,Object> tmap = new HashMap();
//		try {
//			tmap = db.getObject(sql);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String queIds = (String) tmap.get("questions");
//		System.out.println(queIds);
//		for(int i = 0;i<queIds.length();i++){
//			char a = queIds.charAt(i);
//			if(a!=','){
//				queList.add(qd.findQuestionById(a));
//			}
//		}
//		if(queList == null){
//			queList = new ArrayList<Map<String, Object>>();
//		}
//		
		//List l = td.findQuestionsByTestId(2);
		//System.out.println(l.size());
		String t = ToolUtil.getCurrentTime();
		System.out.println(t);
	}
	/**
	 * 获取学生能够答的试卷列表
	 */
	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		/**
		 * 查询近期考试的试卷
		 * 查询的表为itest course student paper 
		 * test表和course的关系： test.courseId = course.id
		 * test  student的关系： 学生所在的班级要在试题针对的班级之内 find_in_set
		 * student和paper ： 如果学生做过试卷 那么在paper中肯定有记录，那么就不让他再做
		 * 别的学生和这个学生做没做没关系，所以paper表中去查学生做没做过，并且注意是这个学生
		 * 所以有s.id = ? and t.id not in (SELECT papers.testId from papers)
		 * s.id = p.studentId  
		 */
		String sql = "SELECT DISTINCT t.id,c.name as courseName ,t.name as testName,t.endDate "
				+ "from test t,student s , course c , papers p "
				+ " WHERE t.courseId = c.id and FIND_IN_SET(s.classId,t.classIds) and s.id = ? and t.endDate >? "
				+ "and t.id not in (SELECT papers.testId from papers) and s.id = p.studentId "
				+ "ORDER BY s.id";
		List tList = new ArrayList();
		
		try {
			tList = db.getQueryList(sql, new Object[]{id,currData});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(tList == null){
			tList = new ArrayList();
		}
		return tList;
	}
	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
	
		String sql = "SELECT t.id,t.name as testName, c.name as courseName, "
				+ "t.endDate,t.questions,t.testTime,t.scores, sc.name as className ,c.id as courseId from test t,student s , course c, stuclass as sc "
				+ "where t.id = ? and FIND_IN_SET(s.classId,t.classIds) and s.id=? and t.courseId = c.id and s.classId = sc.id";
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map = db.getObject(sql, new Object[]{testid,studentid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == map){
			map = new HashMap<String,Object>();
		}
		return map;
	}
}
