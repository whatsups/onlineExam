package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.util.DBUtil;

public class TeacherDao implements ITeacherDao {

	private DBUtil db = new DBUtil();
	
	@Override
	public List<Teacher> findAllTeachersByInfo(String name) {
		// TODO Auto-generated method stub
		List teacherList = new ArrayList();
		String sql="select * from teacher ";
		/**
		 * 支持模糊查找。如果不是查询所有，加where限定条件
		 * 模糊查询的语法是like ‘%...%’
		 */
		if(null!=name){
			sql = sql + " where name like '%" + name +"%'";
		}
		try {
			teacherList = db.getQueryList(Teacher.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacherList;
		
	}
	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql = "insert into teacher values(?,?,?,?)";
		try {
			db.execute(sql, new Object[]{teacher.getId(),teacher.getName(),teacher.getPwd(),teacher.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 测试方法
	 */
	public static void main(String[] args) {
		ITeacherDao td = new TeacherDao();
		List<Teacher> teacherList = td.findAllTeachersByInfo("");
		for(Teacher t : teacherList){
			System.out.println(t.getName());
		}
	}
	@Override
	public void updateTeacherById(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql = "update teacher set name = ? , pwd =?,deptName = ? where id =?";
		try {
			db.execute(sql, new Object[]{teacher.getName(),teacher.getPwd(),teacher.getDeptName(),teacher.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Teacher getTeacherById(int id) {
		// TODO Auto-generated method stub
		Teacher t = new Teacher();
		String sql = "select * from teacher where id = ?";
		try {
			t = (Teacher) db.getObject(Teacher.class,sql,new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(t == null){
			t = new Teacher();
		}
		return t;
	}

}
