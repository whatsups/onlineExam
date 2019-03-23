package com.hp.onlinexam.service.admin;

import java.util.List;

import com.hp.onlinexam.po.StuClass;

/**
 * 接口：班级管理业务层接口
 * @author duye
 *
 */
public interface IStuClassService {
	/**
	 * 查询所有的班级信息
	 * @return 班级的List
	 */
	public List findAll();
	/**
	 * 通过id号查找班级
	 * @param classId 班级的id号 是唯一的
	 * @return 班级对象
	 */
	public StuClass findStuClassById(int classId);
	
	public void addstuClass(StuClass sc);
	
	public void updatestuClass(StuClass sc);
	
	
}
