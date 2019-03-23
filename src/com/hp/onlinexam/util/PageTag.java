package com.hp.onlinexam.util;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 分页查询标签类。
 * @author Administrator
 *
 */
public class PageTag extends SimpleTagSupport{
	
	//当前页
	private int curPage;
	//总页数
	private int totalPage;
	//数据库记录数
	private int rows;
	//访问路径
	private String url;
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public void doTag() throws JspException, IOException {
	 	PageContext pageContext = (PageContext)getJspContext();
	 	JspWriter out = pageContext.getOut();
		out.print("");
		StringBuffer sb = new StringBuffer();
		sb.append("<p>");
		sb.append("总共");
		//插入rows动态数据
		sb.append(rows);
		sb.append("记录&nbsp;&nbsp;共");
		//插入totalPages动态数据
		sb.append(totalPage);		
		sb.append("页&nbsp;");
		sb.append("&nbsp;当前所在页");
		//插入curPage动态数据
		sb.append(curPage);
		sb.append("<a href=");
		//插入url=1
		sb.append(url+"=1");
		sb.append(">首页</a>&nbsp;");
	  	sb.append("<a href=");
	  	//插入上一页url=？
	  	int prePage = curPage <=1 ? curPage: curPage -1;
	  	int nextPage = curPage >= totalPage? totalPage:curPage +1;
	  	
	  	sb.append(url + "=" + prePage);
	  	sb.append(">上一页</a>&nbsp;");
	  	sb.append("<a href=");
	  	//插入下一页url=?
	  	sb.append(url + "=" + nextPage);
	  	sb.append(">下一页</a>&nbsp;");
	   	sb.append("<a href=");
	   	//插入末页
	   	sb.append(url + "=" + totalPage);
	   	sb.append(">未页</a>");
	   	sb.append("</p>");
	   	out.write(sb.toString());
		
	}
	
	
	
	
	
}
