package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;
@WebServlet("/testQueryServlet")
public class TestQueryServlet extends HttpServlet {
	ITestService ts = new TestService();
	ITeacherService teaS = new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Test t = (Test) req.getSession().getAttribute("test");
		//找到所有的没有过期的Test构成testsList
		//req.setAttribute("test", t);
		Teacher loginTeacher = (Teacher)req.getSession().getAttribute("user");
		//根据老师的姓名密码找到唯一的id号
		List allTest = new ArrayList();
		allTest = ts.findAllTest(loginTeacher);
		req.setAttribute("testsList", allTest);
		req.getRequestDispatcher("/teacher/tmain.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher loginTeacher = (Teacher)req.getSession().getAttribute("user");
		//根据老师的姓名密码找到唯一的id号
		List allTest = new ArrayList();
		allTest = ts.findAllTest(loginTeacher);
		req.setAttribute("testsList", allTest);
		req.getRequestDispatcher("/teacher/tmain.jsp").forward(req, resp);
	}
}
