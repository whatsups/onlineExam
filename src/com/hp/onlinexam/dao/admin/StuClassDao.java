package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.util.DBUtil;
/**
 * StuClassDao表示专门访问班级的Dao
 * 因为我们已经定义好了接口，这里实现接口即可
 * 实现接口时，方法已经定义，要实现
 * 实现接口：implements IStuClassDao
 * @author duye
 *
 */
public class StuClassDao implements IStuClassDao  {

	private DBUtil db = new DBUtil();
	@Override
	public List findAllStuClassInfo() {
		// TODO Auto-generated method stub
		//定义一个sql语句，赋给一个字符串类型变量sql
		String sql = "select * from stuclass";
		//new的方式创建，保证它不为null
		List stuClassList = new ArrayList();
		try {
			/**
			 * StuClass.class 表示查询的结果，要封装成那个类型的
			 * 需要加.class不能直接写类名
			 * 直接使用类名的话，在声明变量的时候，可以作为变量的类型
			 * sql完整，参数数组为空
			 */
			stuClassList = db.getQueryList(StuClass.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuClassList;
	}

	@Override
	public StuClass findStuClassById(int classId) {
		// TODO Auto-generated method stub
		//这么写也可以
		//String sql2 = "select * from stuclass where id = "+classId;	
		String sql = "select * from stuclass where id = ?";
		StuClass sc = new StuClass();
		try {
			sc = (StuClass) db.getObject(StuClass.class,sql, new Object[]{classId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sc;
	}
	
	@Override
	public void addStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "insert into stuclass values(?,?,?)";
		try {
			db.execute(sql, new Object[]{sc.getId(),sc.getName(),sc.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void updateStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "update stuclass set name = '"+ sc.getName()+" ',deptName = ' "+sc.getDeptName()+" ' where id  =? ";
		try {
			db.execute(sql, new Object[]{sc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 测试方法
	 * @param args
	 * 如果一个类中有main方法，那么这个类可以使用java Application 运行
	 * 在类上点击右键 运行方式有两种 run 和 debug 
	 * 我们一般选用debug，因为这可以看中间过程，如某个变量的值或某个集合某个对象；
	 * 想要直接看结果用run
	 * 
	 * 对于Web项目，要运行在服务器 Tomcat上 运行后我们能够直接浏览页面
	 * 在运行项目的过程中，如果我们只关注结果 使用 run on Server
	 * 如果在项目运行过程中我们关注中间过程 断点 使用debug on Server
	 * 
	 * 运行类类java aplication是局部
	 * 运行项目是整体
	 * 
	 */
	public static void main(String[] args) {
		IStuClassDao  scd = new StuClassDao();
		//List stuclassList = scd.findAllStuClassInfo();
		StuClass sc = scd.findStuClassById(1);
		System.out.println(sc.getName());
	}




	
}
