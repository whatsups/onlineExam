package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
/**
 *  stuClassQuerySerlet 准们用于出炉查询班级信息
 *  必须继承HttpServlet 才能成为一个Servlet
 *  通过@WebServlet(“”)定义这个类处理的请求地址
 *  /stuClassQueryServlet就是我们的请求地址
 * @author duye
 *
 */
@WebServlet("/stuClassQueryServlet")
public class StuClassQueryServlet extends HttpServlet{
	private IStuClassService scs = new StuClassService();
	/**
	 * 一般get方式用于查询、
	 * 适用场景：1.form表单进行提交 <form action = "" method = "get>
	 * 			2.页面上直接使用一个超链接进行查询
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * scs.findAll()通过对象的方法调用 能够得到查询的所有的班级的信息
		 * 需要有个List容器来接收
		 */
		List list = scs.findAll();
		/**
		 * setAttribute()方法 两个参数 是一对键值对
		 * 键是让前台页面知道数据从这里来的 必须和前台代码中的c:foreach中的名字完全一致，第二个参数-值是对应的要用的值
		 * 前台页面拿到了这个集合，c:foreach迭代显示在页面上
		 */
		req.setAttribute("scList", list);
		req.getRequestDispatcher("manager/stuclassmanage.jsp").forward(req,resp);
		
	}

	
}
