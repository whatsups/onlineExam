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
import com.hp.onlinexam.util.Department;
@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet{
	/**
	 * 处理业务的Sevice对象
	 */
	private IStuClassService scs = new StuClassService();
	/**
	 * 当页面点击“增加班级” 放完的方法
	 * 1.获取页面需要提供的方向名称，并且把数据传递到页面上
	 * 2.页面跳转
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 把servlet中的信息传递到页面上，
		 * Department.values()可以获得所属方向的集合
		 * 页面上，遍历这个集合时起的名字是depList 
		 */
		req.setAttribute("depList", Department.values());
		req.getRequestDispatcher("/manager/stuclassadd.jsp").forward(req, resp);
	}
	/**
	 * doPost方法用来处理计较的新建的班级信息
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 根据控件的名字name获取里面的信息
		 * 严格来说，需要先检验得到的数据的合法性
		 */
		String id = req.getParameter("clanum");
		String name = req.getParameter("claname");
		String deptName = req.getParameter("depInfo"); 
		
		//封装成对象  以便于传参
		StuClass sc = new StuClass();
		/**
		 * integer.valueOf() and integer.parseInt()
		 */
		sc.setId(Integer.valueOf(id));
		sc.setName(name);
		sc.setDeptName(deptName);
		/**
		 * service层开始执行，处理相关业务----service再调用到层执行数据库操作
		 */
		scs.addstuClass(sc);
		/**
		 * 页面跳转  添加完之后一般跳转到查询所有的班级页面
		 * 之前查询的班级信息里不包括新增加的班级
		 * 如果想把班级显示出来，必须再次查询一遍数据库
		 * 之前的stuClassQueryServlet实现了查询功能。因此可以直接跳转到stuClassQueryServlet
		 * 这里添加完成不需要再往页面上添加信息 因此可以用send
		 */
		resp.sendRedirect(req.getContextPath()+"/stuClassQueryServlet");
		//下面这个出错
		//req.getRequestDispatcher(req.getContextPath()+"/stuClassQueryServlet").forward(req,resp);
	}
	
}