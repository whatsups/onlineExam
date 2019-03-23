package com.hp.onlinexam.servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.login.ILoginService;
import com.hp.onlinexam.service.login.LoginService;
import com.hp.onlinexam.util.DBUtil;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	private ILoginService ls = new LoginService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//[1]获取页面上提交的用户名、密码、角色  内容封装在request里，用request的getParameter方法
		String userName = req.getParameter("username");
		String pwd = req.getParameter("password");
		String role = req.getParameter("role");
		//[2]业务处理 ，判断角色，分角色进行处理---判断两个字符串是否相等 使用equals方法
		if("admin".equals(role)){
			//如果是管理员
			if("admin".equals(userName) && "123".equals(pwd)){
				//这个方法能够跳转页面，并且携带了信息，传递参数
				req.getSession().setAttribute("user", userName);
				resp.sendRedirect("manager/mindex.jsp");
				//req.getRequestDispatcher("manager/mindex.jsp").forward(req, resp);
			}else{
				//可以不用sendRe.. 用 req.getRequestDispatcher("...").forward(req, resp);
				 resp.sendRedirect("login.jsp?error=yes");
			}
		}else if("teacher".equals(role)){
			//如果是老师
			Teacher t = new Teacher();
			t.setName(userName);
			t.setPwd(pwd);
			//业务层处理
			Teacher loginTeacher = ls.canLogin(t);
			if(loginTeacher!=null){
				/**
				 * 把当前登录用户放在Session里
				 * key是user
				 * 一个session包含多个请求和响应即request-response
				 */
				req.getSession().setAttribute("user", loginTeacher);
				req.getRequestDispatcher("teacher/tindex.jsp").forward(req, resp);
			}else{
				 resp.sendRedirect("login.jsp?error=yes");
			}
		}else if("student".equals(role)){
			//如果是学生
			Student s = new Student();
			s.setName(userName);
			s.setPwd(pwd);
			Student loginStudent = ls.canLogin(s);
			if(loginStudent != null){
				req.getSession().setAttribute("user", loginStudent);
				req.getRequestDispatcher("/student/index.jsp").forward(req, resp);	
			}else{
				 resp.sendRedirect("login.jsp?error=yes");
			}
		}
	}
}