package com.hp.onlinexam.po;

import java.util.Date;

/**
 * Test类是试卷类	 对应的是学生应该做的试卷
 * @author duye
 *
 */
public class Test {
	private int id;
	//试卷名称
	private String name;
	//所属课程id
	private int courseId;
	//考试截止时间
	private Date endDate;
	//问题集合
	private String questons;
	//试卷对应老师
	private int teacherId;
	//做试卷的班级集合
	private String classIds;
	//试卷考试时长
	private int testTime;
	//学生分数
	private String scores;
	public Test(){
		
	}
	public Test(int id, String name, int courseId, Date endDate, String questons, int teacherId, String classIds,
			int testTime, String scores) {
		super();
		this.id = id;
		this.name = name;
		this.courseId = courseId;
		this.endDate = endDate;
		this.questons = questons;
		this.teacherId = teacherId;
		this.classIds = classIds;
		this.testTime = testTime;
		this.scores = scores;
	}
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getQuestons() {
		return questons;
	}
	public void setQuestons(String questons) {
		this.questons = questons;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getClassIds() {
		return classIds;
	}
	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}
	public int getTestTime() {
		return testTime;
	}
	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
	
	
}
