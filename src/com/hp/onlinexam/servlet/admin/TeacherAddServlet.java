package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;
@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet{
	ITeacherService ts = new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("deptList",Department.values());
		req.getRequestDispatcher("/manager/teacheradd.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("num");
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		String deptName = req.getParameter("dep");
		Teacher t = new Teacher();
		t.setId(Integer.valueOf(id));
		t.setName(name);
		t.setPwd(pwd);
		t.setDeptName(deptName);
		
		ts.addTeacher(t);
		resp.sendRedirect(req.getContextPath()+"/teacherQueryServlet");
	}
}
