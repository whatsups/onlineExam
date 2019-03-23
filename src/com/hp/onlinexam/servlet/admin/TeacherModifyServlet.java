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
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.util.Department;



@WebServlet("/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet{
	private ITeacherService ts = new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		Teacher t = new Teacher();
		t = ts.getTeacherById(Integer.parseInt(id));
		req.setAttribute("teacherInfo", t);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("/manager/teachermodify.jsp").forward(req, resp);
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
		
		ts.upDateTeacher(t);
		resp.sendRedirect(req.getContextPath()+"/teacherQueryServlet");
		
	}
}
