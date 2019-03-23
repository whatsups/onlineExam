package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.util.Department;
@WebServlet("/stuClassModifyServlet")
public class StuClassModifyServlet extends HttpServlet{
	IStuClassService scs = new StuClassService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		String id = req.getParameter("info");
		StuClass stuClassMap=null;
		stuClassMap = scs.findStuClassById(Integer.parseInt(id));

		req.setAttribute("depList", Department.values());
		req.setAttribute("stuClassMap", stuClassMap);
		req.getRequestDispatcher("/manager/stuclassmodify.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req .getParameter("clanum");
		String name = req.getParameter("claname");
		String deptName = req.getParameter("depInfo");
		StuClass sc = new StuClass();
		sc.setId(Integer.valueOf(id));
		sc.setName(name);	
		sc.setDeptName(deptName);
		scs.updatestuClass(sc);
		resp.sendRedirect(req.getContextPath()+"/stuClassQueryServlet");
	}
}
