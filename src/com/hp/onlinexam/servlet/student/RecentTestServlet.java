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
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;
import com.hp.onlinexam.util.ToolUtil;
@WebServlet("/recentTestServlet")
public class RecentTestServlet extends HttpServlet{
	ITestService ts = new TestService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student s = (Student) req.getSession().getAttribute("user");
		List<Map<String,Object>> tList = new ArrayList();
		tList = ts.getTestByStudent(s.getId(), ToolUtil.getCurrentTime());
		req.setAttribute("testsList", tList);
		req.getRequestDispatcher("/student/main.jsp").forward(req, resp);
		
	}
}
