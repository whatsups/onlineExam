package com.hp.onlinexam.po;
/**
 * 封装老师信息的类
 * @author duye
 *
 */
public class Teacher {
	//教师工号
	private int id;
	//老师姓名
	private String name;
	//老师的登录密码
	private String pwd;
	//老师的部门名
	private String deptName;
	//老师的角色编号，如英语老师，物理老师
	private int role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
