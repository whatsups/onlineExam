package com.hp.onlinexam.service.admin;

import java.util.List;

import com.hp.onlinexam.dao.admin.IStuClassDao;
import com.hp.onlinexam.dao.admin.StuClassDao;
import com.hp.onlinexam.po.StuClass;

public class StuClassService implements IStuClassService{
	private IStuClassDao scd = new StuClassDao();
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return scd.findAllStuClassInfo();
	}

	@Override
	public StuClass findStuClassById(int classId) {
		// TODO Auto-generated method stub
		return scd.findStuClassById(classId);
	}

	@Override
	public void addstuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.addStuClassById(sc);
	}

	@Override
	public void updatestuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.updateStuClassById(sc);
	}
	
}
