package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;
@WebServlet("/questionAddServlet")
public class QuestionAddServlet extends HttpServlet{
	private ICourseService couService = new CourseService();
	private IQuestionService queService = new QuestionService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String,Object>> couList = new ArrayList<Map<String,Object>>();
		Teacher loginTeacher = (Teacher)req.getSession().getAttribute("user");
		couList = couService.findCoursesByTeacherId(loginTeacher.getId());
		req.setAttribute("courseList", couList);
		req.getRequestDispatcher("teacher/quesadd.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String couId = req.getParameter("courseId");
		String queType = req.getParameter("queType");
		String queTitle = req.getParameter("queTitle");
		String choiceA = req.getParameter("choiceA");
		String choiceB = req.getParameter("choiceB");
		String choiceC = req.getParameter("choiceC");
		String choiceD = req.getParameter("choiceD");
		String ans = req.getParameter("ans");
		Question q = new Question(Integer.parseInt(couId),Integer.parseInt(queType),queTitle,choiceA,choiceB,choiceC,choiceD,ans);
		queService.addQuestion(q);
		resp.sendRedirect(req.getContextPath()+"/questionQueryServlet");
	}
	
	public static void main(String[] args) {
		List couList = new ArrayList();
		Teacher loginTeacher = new Teacher();
		loginTeacher.setName("斯大林");
		ICourseService couService = new CourseService();
		couList = couService.findAllCourses(loginTeacher.getName());
		System.out.println(couList.size());
	}
}
