package com.hp.onlinexam.dao.login;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.util.DBUtil;

public class LoginDao implements ILoginDao{
	private DBUtil db = new DBUtil();
	@Override
	public Teacher canLogin(Teacher t) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher where name = ? and pwd = ?";
		List teaList = new ArrayList();
		
		
		try {
			teaList = db.getQueryList(Teacher.class, sql, new Object[]{t.getName(),t.getPwd()});
			//也可以用getObject方法
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != teaList && teaList.size() > 0)
			return (Teacher) teaList.get(0);
		else
		    return null;
	}
	@Override
	public Student canLogin(Student s) {
		// TODO Auto-generated method stub
		String sql = "select * from student where name = ? and pwd = ?";
		List stuList = new ArrayList();
		try {
			stuList = db.getQueryList(Student.class, sql, new Object[]{s.getName(),s.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=stuList && stuList.size()>0){
			return (Student)stuList.get(0);
		}else
			return null;
	}
	public static void main(String[] args) {
		LoginDao ld = new LoginDao();
		Student s = new Student();
		s.setName("www");
		s.setPwd("123");
		Student ss = ld.canLogin(s);
		System.out.println(ss.getName()+"---"+ss.getPwd());
		
	}
}
