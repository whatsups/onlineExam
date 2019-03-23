package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Paper;
import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.student.IPaperService;
import com.hp.onlinexam.service.student.PaperService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;
import com.hp.onlinexam.util.ToolUtil;
@WebServlet("/studentTest")
public class StudentTest extends HttpServlet {
	ITestService ts = new TestService();
	IQuestionService qs = new QuestionService();
	IPaperService ps = new PaperService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String testId = req.getParameter("testId");
		Student s = (Student)req.getSession().getAttribute("user");
		Map testMap = ts.findStudentTestsById(s.getId(), Integer.parseInt(testId));
		List<Question> queList = qs.findQuestionByIds((String)testMap.get("questions"));
	
		req.setAttribute("scoreperques", 1.0*Integer.parseInt((String) (testMap.get("scores")))/queList.size());
		/**
		 * 需要在多个request和response之间传递试卷信息和试题信息
		 * 因此需要把这些信息保存到session中
		 */
		req.getSession().setAttribute("test", testMap);
		req.getSession().setAttribute("quesList", queList);

		req.getRequestDispatcher("/student/exam.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//从页面上获取答题时间信息
		String time = req.getParameter("hidden1");
		//从session中获取试题信息
		List quesList = (List) req.getSession().getAttribute("quesList");
		//从session中获取试卷信息
		Map testMap = (Map) req.getSession().getAttribute("test");
		if (null == quesList || quesList.size()<1)
			return ;
		StringBuffer wrongQueId = new StringBuffer();
		StringBuffer wrongAns = new StringBuffer();
		//目的是遍历试卷中的试题的集合
		int wrongQueNum = 0;
		for (int i = 0 ; i < quesList.size();i++){
		Question q = (Question) quesList.get(i);
		//页面接收的答案
		String ans = req.getParameter("ques_"+q.getId()).toUpperCase();
		//如果和标准答案不匹配，则记录错误的题号和错误答案
		if (!q.getAns().equals(ans)){
		wrongQueId.append(q.getId()).append(",");
		wrongAns.append(ans).append(",");
		wrongQueNum++;
		}
		}
		//System.out.println(wrongQueId.toString());
		//System.out.println(wrongAns.toString());
		Paper p = new Paper();
		p.setTestId((int) testMap.get("id"));
		p.setCourseId((int) testMap.get("courseId"));
		p.setTime(time);
		//获得试题的总分和错误试题的数量
		if (quesList.size()>wrongQueNum)
		p.setScore(1.0*Integer.parseInt((String) (testMap.get("scores")))/quesList.size()*(quesList.size()-wrongQueNum));
		else
		p.setScore(0);
		/**
		 * 如果做的全对，那么wrongQueId和wrongAns，都是空
		 * 如果有错题，那么多带了一个逗号
		 */
		String wrongQueIdString = wrongQueId.toString();
		String wrongAnsString = wrongAns.toString();
		if (wrongQueIdString.endsWith(",")){
		wrongQueIdString = wrongQueIdString.substring(0, wrongQueIdString.length()-1);
		wrongAnsString = wrongAnsString.substring(0, wrongAnsString.length()-1);
		}
		p.setWrongQueId(wrongQueIdString);
		p.setWrongAns(wrongAnsString);
		Student s = (Student) req.getSession().getAttribute("user");
		p.setStudentId(s.getId());
		Date date = new Date();
		//SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	
		p.setCreateData(date);
		ps.save(p);
		/**
		 * 开始考试的时候，在页面的超链接上，使用了target="_parent"
		 * 跳出了frame框架，因此，重定向的时候需要再定向到frame里
		 */
		resp.sendRedirect(req.getContextPath()+"/student/index.jsp");
	}
}