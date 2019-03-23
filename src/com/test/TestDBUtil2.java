package com.test;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.util.DBUtil;

public class TestDBUtil2 {
	public static void main(String[] args) {
		DBUtil db = new DBUtil();
		String sql = "SELECT * from student where id = ?";
		try {
			Student s = (Student)db.getObject(Student.class,sql, new Object[]{4});
			System.out.println(s.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
