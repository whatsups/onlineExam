package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.vo.TeacherCourseView;

public class ScheduleDao implements IScheduleDao{
	
	private DBUtil db = new DBUtil();
	@Override
	public List<TeacherCourseView> findScheduleByCourseName(String name) {
		// TODO Auto-generated method stub
	    List tcList = new ArrayList();
	    String sql="SELECT tc.id tcId,tc.courseId tcCourseId, tc.teaId tcTeaId, tea.id teacherId, tea.name teacherName,sc.id stuclassId, sc.name stuclassName,  tea.deptName ,c.id courseId,c.name courseName "
	    		+ "FROM teachercourse AS tc,teacher AS tea,course AS c,stuclass AS sc "
	    		+ " WHERE  tc.courseid = c.id AND tc.teaid = tea.id AND tc.classId = sc.id ORDER BY sc.name ASC";
	    if(name != null){
	    	sql = "SELECT tc.id tcId,tc.courseId tcCourseId, tc.teaId tcTeaId, tea.id teacherId, tea.name teacherName,sc.id stuclassId, sc.name stuclassName,  tea.deptName ,c.id courseId,c.name courseName FROM teachercourse AS tc,teacher AS tea,course AS c,stuclass AS sc  	WHERE  tc.courseid = c.id AND tc.teaid = tea.id AND tc.classId = sc.id AND c.name like '%"+ name +"%' ORDER BY sc.name ASC";
	    }
	    try {
			tcList = db.getQueryList(TeacherCourseView.class,sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tcList; 
	}
	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		String sqll = "select * from teachercourse where teaId =? and courseId=? and classId=?";
		List list = new ArrayList();
		try {
			list = db.getQueryList(sqll, new Object[]{tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(list.size()!=0) return;
		String sql = "insert into teachercourse(teaId,courseId,classId) values(?,?,?)";
		try {
			db.execute(sql, new Object[]{tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		String sql = "update teachercourse set teaId = ? ,classId = ? ,courseId = ? where id = ?";
		try {
			db.execute(sql, new Object[]{tc.getTeaId(),tc.getClassId(),tc.getCourseId(),tc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void scheduleDelete(int scheduleId) {
		// TODO Auto-generated method stub
		String sql = "delete from teachercourse where id = "+scheduleId;
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public TeacherCourse getTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		
		String sql = "select * from teachercourse where id = ?";
		TeacherCourse teacherCourse = new TeacherCourse();
		try {
			teacherCourse = (TeacherCourse) db.getObject(TeacherCourse.class, sql, new Object[]{id});
					} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(teacherCourse == null){
			teacherCourse = new TeacherCourse();
		}
		return teacherCourse;
	}
}
