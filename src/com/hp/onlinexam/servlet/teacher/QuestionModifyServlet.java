package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.util.DBUtil;
@WebServlet("/questionModifyServlet")
public class QuestionModifyServlet extends HttpServlet{
	ICourseService couService = new CourseService();
	IQuestionService queService = new QuestionService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		Map<String,Object> q = queService.findQuestionById(Integer.parseInt(id));
		List courseList = couService.findAllCourses(null);
		req.setAttribute("id", id);
		req.setAttribute("questionMap", q);
		req.setAttribute("courseList", courseList);
		req.getRequestDispatcher("teacher/quesmodify.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String couId = req.getParameter("courseId");
		String queType = req.getParameter("queType");
		String queTitle = req.getParameter("queTitle");
		String choiceA = req.getParameter("choiceA");
		String choiceB = req.getParameter("choiceB");
		String choiceC = req.getParameter("choiceC");
		String choiceD = req.getParameter("choiceD");
		String ans = req.getParameter("ans");
		Question q = new Question(Integer.parseInt(couId),Integer.parseInt(queType),queTitle,choiceA,choiceB,choiceC,choiceD,ans);
		q.setId(Integer.parseInt(id));
		queService.updateQue(q);
		resp.sendRedirect(req.getContextPath()+"/questionQueryServlet");
		
	}
}
