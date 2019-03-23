package com.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.util.DBUtil;

public class TestDBUtil {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DBUtil db = new DBUtil();
//		String sql = "select student.stuname,student.school,student.sex,student.born,stuclass.className "
//				+ "from student,stuclass where student.stuname like '%zhang%' and student.classid = stuclass.id;";
//		List<Map<String,Object>> stuList = db.getQueryList(sql);
//		System.out.println(stuList.size());
//		for(int i = 0;i<stuList.size();i++){
//			Map<String,Object> map = stuList.get(i);
//			Set<String> set = map.keySet();
//			for(String s : set){
//				System.out.println(s+"---"+map.get(s));
//			}
//			System.out.println("--------------------------");
//		}
//		
//		System.out.println("--------------------我是分割线----------------------");
//		String sql2 = "select stuname,school,sex,born "
//				+ "from student where student.school = ? and student.sex = ?";
//			List<Map<String,Object>> stulist2 = db.getQueryList(sql2, new Object[]{"ouc","男"});
//			System.out.println(stulist2.size());
//			
//			for(int i = 0;i<stulist2.size();i++){
//				Map<String,Object> map2 = stulist2.get(i);
////				Set<String> set2 = map2.keySet();
////				for(String s:set2){
////					System.out.println(s+"----"+map2.get(s));
////				}
//				System.out.println("-----------------------------------------");
//				Iterator<Map.Entry<String, Object>> it = map2.entrySet().iterator();
//				while(it.hasNext()){
//					Map.Entry<String, Object> m = it.next();
//					System.out.println(m.getKey()+"---"+m.getValue());
//				}
//			}
//		
//		System.out.println("--------------------我是分割线----------------------");
		
//		String sql3 = "SELECT * from test where  teacherId = ? and courseId = ?";
//		List<?> list3 = db.getQueryList(Test.class, sql3, new Object[]{1,1});
//		System.out.println(list3.size());
//		for(int i = 0;i<list3.size();i++){
//			Test test = (Test)list3.get(i);
//			System.out.println(test.getId()+"---"+test.getName()+"---"+test.getClassIds()+"----"+test.getTestTime()+"---"+test.getScores());
//		}
//		
//		String sql6 = "update  course set name = 'ssh' where id = 12";
//		db.execute(sql6);
		
//		String sql7 = "update teacher set name = ? where name ='李白'";
//		db.execute(sql7, new Object[]{"李贺"});
//		
//		String sql5 = "SELECT * from student where pwd = ?";
//		List<?> list4 = db.getQueryList(Student.class, sql5, new Object[]{"123"});
//		System.out.println(list4.size());
//		for(int i = 0;i<list4.size();i++){
//			Student s = (Student)list4.get(i);
//			System.out.println(s.getName()+"---"+s.getBorn()+"---"+s.getDeptName()+"---"+s.getClassid()+"--"
//					+s.getSchool()+"---"+s.getSex());
//		}
//		String sql4 = "SELECT test.* from test,teacher ,course where test.courseId = course.id AND course.`name` =? "
//				+ "AND test.teacherId = teacher.id AND teacher.name = ?";
//		
//		List<Map<String,Object>> testList = db.getQueryList(sql4, new Object[]{"java基础开发","yao"});
//		System.out.println(testList.size());
//		
//		for(int i = 0;i<testList.size();i++){
//			Map<String,Object> map = testList.get(i);
//			Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
//			while(it.hasNext()){
//				Map.Entry<String, Object> me = it.next();
//				System.out.println(me.getKey()+"------"+me.getValue());
//			}
//		}
		
//		DBUtil db = new DBUtil();
//		String sql = "select * from course";
//		List<Map<String,Object>>courseList = db.getQueryList(sql);
//		System.out.println(courseList.size());
		/**
		 * List的遍历，从0开始循环size()次
		 */
		
		
//		for(int i = 0;i<courseList.size();i++){
//			Map<String,Object> map = courseList.get(i);
//			Set<String> set = map.keySet();
//			
//			for(String key:set){
//				System.out.println(key+"---"+map.get(key));
//			}
//			
//			Iterator it = map.entrySet().iterator();
//			while(it.hasNext()){
//				Entry courseEntry = (Entry)it.next();
//				System.out.println("key是"+courseEntry.getKey()+",value是"+courseEntry.getValue());
//			}
			
//			Set<Map.Entry<String, Object>> set = map.entrySet();
//			
//			for(Map.Entry<String, Object> me :set){
//				System.out.println(me.getKey()+"---"+me.getValue());
//			}
//			
//		}
		for(int i = 1606;i<10000;i++){
			String sql = "insert into student values(?,?,?,?,?,?,?,?)";
			db.execute(sql, new Object[]{i,"测试"+i,"123","ouc","开发","男","1990-10-10","6"});
		}
		
		
		
	}
}
