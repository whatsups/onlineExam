package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.util.DBUtil;

public class StudentDao implements IStudentDao{
	private DBUtil db = new DBUtil();
	@Override
	public List<Map<String,Object>> findStudentByName(String stuname) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> sList = new ArrayList<Map<String,Object>>();
		String sql;
		if(stuname == null || stuname ==""){
			sql = "select s.id id,s.name name,s.sex sex,s.born born, s.pwd pwd,s.school school,"
					+ "s.deptName deptName,sc.name className "
					+ "from student s,stuclass sc where s.classid = sc.id";
		}
//		String sql = "select s.id id,s.name name,s.sex sex,s.born born, s.pwd pwd,s.school school,"
//				+ "s.deptName deptName,sc.name className "
//				+ "from student s,stuclass sc where s.classid = sc.id";
		else{
			sql = "select s.id id,s.name name,s.sex sex,s.born born, s.pwd pwd,s.school school,"
					+ "s.deptName deptName,sc.name className "
					+ "from student s,stuclass sc where s.classid = sc.id and s.name like '%"+stuname+"%'";
		}
		try {
			sList = db.getQueryList(sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sList == null){
			sList = new ArrayList<Map<String,Object>>();
		}
		return sList;
	}

	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "insert into student  values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{s.getId(),s.getName(),s.getPwd(),s.getSchool(),s.getDeptName(),s.getSex(),s.getBorn(),s.getClassid()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		String sql = "update student set name = ?,pwd = ?,school = ?,deptName = ?,sex = ?,born = ?,classid =? where id = ?";
		try {
			db.execute(sql, new Object[]{s.getName(),s.getPwd(),s.getSchool(),s.getDeptName(),s.getSex(),s.getBorn(),s.getClassid(),s.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from student where id = "+id;
		Student s  = new Student();
		try {
			s = (Student) db.getObject(Student.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s == null){
			 s  = new Student();
		}
		return s;
	}

}
