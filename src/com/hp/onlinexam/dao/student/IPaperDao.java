package com.hp.onlinexam.dao.student;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Paper;
import com.hp.onlinexam.po.Student;

public interface IPaperDao {

	public void save(Paper p);
	public List<Map<String,Object>> getLastPaper(Student s,String courseName);
}
