package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
@WebServlet("/courseQueryServlet")
public class CourseQueryServlet extends HttpServlet{
	private ICourseService cs = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Course> courseList = new ArrayList<Course>();
		courseList = cs.findAllCourses(null);
		req.setAttribute("tcList", courseList);
//		req.getParameterNames();
//		req.getParameterMap();
		req.getRequestDispatcher("manager/coursemanage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("courseSearch");
		List<Course> courseList = new ArrayList<Course>();
		courseList = cs.findAllCourses(name);
//		Cookie c = new Cookie("userId", "134");
//		req.setAttribute("123", 123);
//		req.getSession().setAttribute("123", "123");
//		req.getSession().getAttribute("123");
////		resp.addCookie(c);
		HttpSession s = req.getSession();
//		ServletConfig sc = this.getServletConfig();
//		sc.getInitParameter("123");
//		RequestDispatcher r = new RequestDispatcher(){
//			
//			@Override
//			public void include(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void forward(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//				// TODO Auto-generated method stub
//				
//			}
//		};
//		s.invalidate();
//	this.getServletContext().getRequestDispatcher("\1212");
//		req.getCookies();
//		req.setAttribute("tcList", courseList);
////		resp.sendRedirect("");
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding("UTF-8");
//		OutputStream out = resp.getOutputStream();
//		out.println("132");
//		resp.sendRedirect("");
//	req.getRequestDispatcher("url").forward(req, resp);
		req.getRequestDispatcher("/manager/coursemanage.jsp").forward(req, resp);
	}
}
