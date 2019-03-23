package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.student.IPaperService;
import com.hp.onlinexam.service.student.PaperService;
@WebServlet("/pastTestServlet")
public class PastTestServlet extends HttpServlet{
	IPaperService ps = new PaperService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student user = new Student();
		user = (Student) req.getSession().getAttribute("user");
		List<Map<String,Object>> historyList = new ArrayList();
		historyList = ps.getLastPaper(user,null);
		
		req.setAttribute("user", user);
		req.setAttribute("paperList", historyList);
		req.getRequestDispatcher("student/history.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student user = new Student();
		user = (Student) req.getSession().getAttribute("user");
		String courseName = req.getParameter("courseSearch");
		List<Map<String,Object>> historyList = new ArrayList();
		historyList = ps.getLastPaper(user,courseName);
		
		req.setAttribute("user", user);
		req.setAttribute("paperList", historyList);
		req.getRequestDispatcher("student/history.jsp").forward(req, resp);
	}
}
