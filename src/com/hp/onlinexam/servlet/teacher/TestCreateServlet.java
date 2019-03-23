package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;
@WebServlet("/testCreateServlet")
public class TestCreateServlet extends HttpServlet {
	ITestService ts = new TestService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Test t = (Test) req.getSession().getAttribute("test");
		ts.addTest(t);
		req.getSession().removeAttribute("test");
		//重定向到近期考试的servlet
		resp.sendRedirect(req.getContextPath()+"/testQueryServlet");


	}
}
