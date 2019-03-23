package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;
@WebServlet("/questionQueryServlet")
public class QuestionQueryServlet extends HttpServlet{
	private IQuestionService qs = new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List queList = new ArrayList();
		queList = qs.findAll(null, null);
		req.setAttribute("queList", queList);
		req.getRequestDispatcher("teacher/questionmanage.jsp").forward( req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String selected = req.getParameter("selectk");
		String searchName = req.getParameter("searchName");
		List queList = new ArrayList();
		queList = qs.findAll(selected, searchName);
		req.setAttribute("queList", queList);
		req.getRequestDispatcher("teacher/questionmanage.jsp").forward( req, resp);
		
	}
}
