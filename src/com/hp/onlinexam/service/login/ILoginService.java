package com.hp.onlinexam.service.login;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;

public interface ILoginService {
	public Teacher canLogin(Teacher t);
	
	public Student canLogin(Student s);
}
