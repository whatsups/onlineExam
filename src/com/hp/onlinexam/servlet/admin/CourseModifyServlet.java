package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.util.DBUtil;
@WebServlet("/courseModifyServlet")
public class CourseModifyServlet extends HttpServlet{
	ICourseService sc = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("info");
		
		Course c = new Course();
		try {
			c = sc.findCourseById(Integer.parseInt(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("course", c);
		req.getRequestDispatcher("manager/coursemodify.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String name = req.getParameter("courname");
		Course cou = new Course();
		cou.setId(Integer.valueOf(id));
		cou.setName(name);
		sc.updateCourse(cou);
		resp.sendRedirect(req.getContextPath()+"/courseQueryServlet");
	}
}
