package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.util.DBUtil;

public class CourseDao implements ICourseDao {
	private DBUtil db = new DBUtil();
	@Override
	public List<Course> findAllCourses(String name) {
		// TODO Auto-generated method stub
		String sql;
		if(name == null || name ==""){
			sql ="select * from course";
		}else{
			sql = "select * from course where name like '%" + name +"%'";
		}
		List list = new ArrayList();
		try {
			list = db.getQueryList(Course.class,sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void addCourseByName(String name) {
		// TODO Auto-generated method stub
		String sql = "insert into course(name) values(?)";
		try {
			db.execute(sql, new Object[]{name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void updateCourseById(Course c) {
		// TODO Auto-generated method stub
		String sql = "update course set name = ? where id = ?";
		try {
			db.execute(sql, new Object[]{c.getName(),c.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from course where id = "+id;
		Course c = new Course();
		try {
			c = (Course) db.getObject(Course.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c == null){
			c = new Course();
		}
		return c;
	}
	@Override
	
		// TODO Auto-generated method stub
		public String findClassNamesByIds(String ids) {
			// TODO Auto-generated method stub
			String sql = "SELECT name from stuclass where id in ("+ids+")";
			List<Map<String, Object>> nameList = new ArrayList();
			try {
			nameList = db.getQueryList(sql, new Object[]{});
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			if (null == nameList)
			return "";
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < nameList.size();i++){
			sb.append(nameList.get(i).get("name")).append(" ");
			}
			return sb.toString();

	}
	
	@Override
	public List<Map<String,Object>> findCoursesByTeacherId(int id) {
		// TODO Auto-generated method stub
		String sql ="select DISTINCT c.id id ,c.name name from course c,teachercourse tc where tc.teaId = ? and c.id = tc.courseId";
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			list = db.getQueryList(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list == null){
			list = new ArrayList();
		}
		return list;
	}
	public static void main(String[] args) {
		ICourseDao cd = new CourseDao();
		List l = cd.findCoursesByTeacherId(1);
		System.out.println(l.size());
		System.out.println("--------");
	}
}
