package com.hp.onlinexam.service.student;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.student.IPaperDao;
import com.hp.onlinexam.dao.student.PaperDao;
import com.hp.onlinexam.po.Paper;
import com.hp.onlinexam.po.Student;

public class PaperService implements IPaperService{
	IPaperDao pd = new PaperDao();
	@Override
	public void save(Paper p) {
		// TODO Auto-generated method stub
		pd.save(p);
	}
	@Override
	public List<Map<String, Object>> getLastPaper(Student s,String courseName) {
		// TODO Auto-generated method stub
		return pd.getLastPaper(s,courseName);
	}

}
