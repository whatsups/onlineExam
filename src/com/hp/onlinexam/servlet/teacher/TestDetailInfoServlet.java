package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;
@WebServlet("/testDetailInfoServlet")
public class TestDetailInfoServlet extends HttpServlet{
	ITestService ts = new TestService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String testId = req.getParameter("id");
		Map<String,Object> test = new HashMap<String,Object>();
		test = ts.findTestById(Integer.parseInt(testId));
		req.setAttribute("test", test);
		List<Map<String,Object>> queList = new ArrayList();
		queList = ts.findQuestionsByTestId(Integer.parseInt(testId));
		req.setAttribute("quesList", queList);
		req.getRequestDispatcher("teacher/viewtest.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.sendRedirect(req.getContextPath()+"/testQueryServlet");
		
	}
}
