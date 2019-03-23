package com.hp.onlinexam.dao.admin;

import java.util.List;

import com.hp.onlinexam.po.StuClass;

/**
 * 班级管理中的dao接口
 * dao专门用于管理数据库
 * @author duye
 *
 */
public interface IStuClassDao {
	/**
	 * 查询所有班级信息
	 * @return
	 */
	public List findAllStuClassInfo();
	/**
	 * 查询某个指定id的班级信息
	 * @param classId
	 * @return
	 */
	public StuClass findStuClassById(int classId) ;
	
	public void addStuClassById(StuClass sc);
	public void updateStuClassById(StuClass sc);
	
	
}
