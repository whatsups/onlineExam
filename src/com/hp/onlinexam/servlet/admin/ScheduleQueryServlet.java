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

import com.hp.onlinexam.service.admin.IScheduleService;
import com.hp.onlinexam.service.admin.ScheduleService;
import com.hp.onlinexam.vo.TeacherCourseView;
@WebServlet("/scheduleQueryServlet")
public class ScheduleQueryServlet extends HttpServlet{
	IScheduleService ss = new ScheduleService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<TeacherCourseView> tcList = new ArrayList<TeacherCourseView>();
		tcList = ss.findScheduleByCourseName(null);
		req.setAttribute("tcList", tcList);
		req.getRequestDispatcher("manager/schedulemanage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<TeacherCourseView> tcList = new ArrayList<TeacherCourseView>();
		String name = req.getParameter("courseSearch");
		tcList = ss.findScheduleByCourseName(name);
		req.setAttribute("tcList", tcList);
		req.getRequestDispatcher("manager/schedulemanage.jsp").forward(req, resp);
	}
}
