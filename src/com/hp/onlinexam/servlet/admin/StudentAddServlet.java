package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.Department;

@WebServlet("/studentAddServlet")
public class StudentAddServlet extends HttpServlet{
	IStuClassService classService = new StuClassService();
	IStudentService stuService = new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<StuClass> stuClassList = new ArrayList<StuClass>();
		stuClassList = classService.findAll();
		req.setAttribute("classList", stuClassList);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/studentadd.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String born = req.getParameter("born");
		String school = req.getParameter("school");
		String deptName = req.getParameter("deptName");
		String classId = req.getParameter("classId");
		Student s = new Student();
		s.setId(Integer.parseInt(id));
		s.setBorn(born);
		s.setClassid(Integer.parseInt(classId));
		s.setDeptName(deptName);
		s.setName(name);
		s.setPwd(pwd);
		s.setSchool(school);
		s.setSex(sex);
		stuService.addStudent(s);
		
		resp.sendRedirect(req.getContextPath()+"/studentQueryServlet");
		
		
		
		
		
		
		
	}
}
