package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.util.Department;
@WebServlet("/studentModifyServlet")
public class StudentModifyServlet extends HttpServlet{
	IStuClassService scs = new StuClassService();
	IStudentService ss = new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DBUtil db = new DBUtil();
		String id = req.getParameter("id");
		String sql2 = "select * from stuclass";
		Student s  = new Student();
		List classList = new ArrayList();
		s = ss.findStudentById(Integer.parseInt(id));
		classList = scs.findAll();
		
		req.setAttribute("student", s);
		req.setAttribute("deptList", Department.values());
		req.setAttribute("classList",classList );
		req.getRequestDispatcher("manager/studentmodify.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String born = req.getParameter("born");
		String school = req.getParameter("school");
		String deptId = req.getParameter("deptId");
		String classId = req.getParameter("classId");
		Student s = new Student();
		s.setId(Integer.parseInt(id));
		s.setBorn(born);
		s.setClassid(Integer.parseInt(classId));
		s.setDeptName(deptId);
		s.setName(name);
		s.setPwd(pwd);
		s.setSchool(school);
		s.setSex(sex);
		
		ss.updateStudentInfo(s);
		resp.sendRedirect(req.getContextPath()+"/studentQueryServlet");
	
	}
}
