package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.TestService;
import com.hp.onlinexam.util.ToolUtil;
@WebServlet("/testAddServlet")
public class TestAddServlet extends HttpServlet{
	ITestService ts = new TestService();
	IQuestionService qs = new QuestionService();
	ICourseService sc = new CourseService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Course> courseList = new ArrayList<Course>();
		List<StuClass> stuClassList =new ArrayList<StuClass>();
		Teacher loginTeacher = (Teacher)req.getSession().getAttribute("user");
		courseList = ts.findCourseByTeacherId(loginTeacher.getId());
		stuClassList = ts.findStuClassByTeacherId(loginTeacher.getId());
		req.setAttribute("courseList", courseList);
		req.setAttribute("classesList", stuClassList);
		req.getRequestDispatcher("/teacher/testadd.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher loginTeacher = (Teacher)req.getSession().getAttribute("user");
		String courseId = req.getParameter("courseid");
		String testName = req.getParameter("testname");
		String endDate = req.getParameter("enddate");
		String score = req.getParameter("sinscores");
		String queNum = req.getParameter("sinnum");
		String testTime = req.getParameter("testtime");
		String [] classIds = req.getParameterValues("classCheck");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		try {
		date = formatter.parse(endDate);
		} catch (ParseException e) {
		e.printStackTrace();
		}
		Course c = sc.findCourseById(Integer.parseInt(courseId));
		List<Map<String,Object>> questionList = 
				qs.collectQuestions(Integer.parseInt(courseId),Integer.parseInt(queNum));
		Test t = new Test();
		t.setName(testName);
		t.setCourseId(Integer.parseInt(courseId));
		t.setEndDate(date);
		t.setScores(score);
		t.setTeacherId(loginTeacher.getId());
		t.setTestTime(Integer.parseInt(testTime));
		t.setClassIds(ToolUtil.arraytoString(classIds));
		t.setQuestons(qs.getQueIdsByQueList(questionList));
		
		StringBuffer classIdStringBuffer = new StringBuffer();
		for(int i = 0;i<classIds.length;i++){
			if(i == classIds.length-1){
				classIdStringBuffer.append(classIds[i]);
			}else{
				classIdStringBuffer.append(classIds[i]).append(",");
			}
		}
		String classNames = ts.findClassNamesByIds(classIdStringBuffer.toString());
		req.setAttribute("c", c);
		//使用session来暂时保存一下
		req.getSession().setAttribute("test", t);
		req.setAttribute("classNames", classNames);
		req.setAttribute("quesList", questionList);

		req.getRequestDispatcher("/teacher/test.jsp").forward(req, resp);

	}
}
