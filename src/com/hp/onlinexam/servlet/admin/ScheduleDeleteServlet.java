package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.IScheduleService;
import com.hp.onlinexam.service.admin.ScheduleService;
import com.hp.onlinexam.util.DBUtil;
@WebServlet("/scheduleDeleteServlet")
public class ScheduleDeleteServlet extends HttpServlet{
	IScheduleService ss = new ScheduleService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("info");
		ss.scheduleDelete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath()+"/scheduleQueryServlet");
	}

}
