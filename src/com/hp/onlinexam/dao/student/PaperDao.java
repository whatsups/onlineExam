package com.hp.onlinexam.dao.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Paper;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.util.DBUtil;

public class PaperDao implements IPaperDao{
	DBUtil db = new DBUtil();
	@Override
	public void save(Paper p) {
		// TODO Auto-generated method stub
		String sql = "insert into papers(testId,courseId,time,score,wrongQueId,wrongAns,studentId,createDate) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{p.getTestId(),p.getCourseId(),p.getTime(),p.getScore(),p.getWrongQueId(),p.getWrongAns(),p.getStudentId(),p.getCreateData()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Map<String, Object>> getLastPaper(Student s,String courseName) {
		// TODO Auto-generated method stub
		String sql = "select p.time,t.name testName,p.createDate,p.score,c.name courseName from papers p,course c,test t "
				+ "where p.courseId=c.id and p.testId = t.id and p.studentId = ? ORDER BY createDate DESC";
		if(courseName != null && courseName != ""){
			sql = "select p.time,t.name testName,p.createDate,p.score,c.name courseName from papers p,course c,test t "
					+ "where p.courseId=c.id and p.testId = t.id and p.studentId = ?  "
					+ "AND c.name like '%"+courseName+"%' ORDER BY createDate DESC";
		}
		List historyList = new ArrayList();
		try {
			historyList = db.getQueryList(sql,new Object[]{s.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(historyList == null){
			historyList = new ArrayList();
		}
		return historyList;
	}
}
