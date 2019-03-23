package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;
@WebServlet("/questionDeleteServlet")
public class QuestionDeleteServlet extends HttpServlet{
	IQuestionService qs = new QuestionService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		qs.deleteQue(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath()+"/questionQueryServlet");
	}
}
