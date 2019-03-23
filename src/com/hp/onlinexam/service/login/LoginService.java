package com.hp.onlinexam.service.login;

import com.hp.onlinexam.dao.login.ILoginDao;
import com.hp.onlinexam.dao.login.LoginDao;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
/**
 * 判断是否能登录
 * @author duye
 *
 */
public class LoginService implements ILoginService{
	ILoginDao ld = new LoginDao();
	/**
	 * 判断是否能登录
	 * 返回null说明用户不存在或者用户名密码不匹配，否则，则返回一个Teacher对象，可以登陆
	 */
	@Override
	public Teacher canLogin( Teacher t) {
		// TODO Auto-generated method stub
		return ld.canLogin(t);
	}
	@Override
	public Student canLogin(Student s) {
		// TODO Auto-generated method stub
		return ld.canLogin(s);
	}
}
