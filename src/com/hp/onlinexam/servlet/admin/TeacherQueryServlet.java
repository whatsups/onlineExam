package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
@WebServlet("/teacherQueryServlet")
public class TeacherQueryServlet extends HttpServlet{
	private ITeacherService ts = new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List teacherList = new ArrayList();
		teacherList = ts.findTeachers("");
		req.setAttribute("teacherList", teacherList);
		req.getRequestDispatcher("manager/teachermanage.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		List teacherList = new ArrayList();
		teacherList = ts.findTeachers(name);
		req.setAttribute("teacherList", teacherList);
		req.getRequestDispatcher("manager/teachermanage.jsp").forward(req,resp);
	}
}
