package com.hp.onlinexam.dao.login;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;

public interface ILoginDao {
	public Teacher canLogin(Teacher t);
	public Student canLogin(Student s);
}
