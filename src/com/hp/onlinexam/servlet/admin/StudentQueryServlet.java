package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StudentService;
@WebServlet("/studentQueryServlet")
public class StudentQueryServlet extends HttpServlet{
	IStudentService stuService = new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list = stuService.findStudent(null);
		req.setAttribute("studentList", list);
		req.getRequestDispatcher("manager/studentmanage.jsp").forward(req,resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name  = req.getParameter("name");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list = stuService.findStudent(name);
		req.setAttribute("studentList", list);
		req.getRequestDispatcher("manager/studentmanage.jsp").forward(req,resp);
	}
}
