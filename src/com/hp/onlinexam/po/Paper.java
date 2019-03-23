package com.hp.onlinexam.po;

import java.util.Date;

/**
 * 这是学生答的试卷类，是学生做完之后的试卷
 * @author duye
 *
 */
public class Paper {
	//id是试卷的标识
	private int id;
	//此试卷属于测试的id
	private int testId;
	//属于课程的id
	private int courseId;
	//试卷做题时间
	private String time;
	//本试卷得分
	private double score;
	//学生做错了的问题标号集合
	private String wrongQueId;
	//学生做错了，他选的错误答案的集合·
	private String wrongAns;
	//做题的学生的id
	private int studentId;
	//试卷的提交时间
	private Date createData;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getWrongQueId() {
		return wrongQueId;
	}
	public void setWrongQueId(String wrongQueId) {
		this.wrongQueId = wrongQueId;
	}
	public String getWrongAns() {
		return wrongAns;
	}
	public void setWrongAns(String wrongAns) {
		this.wrongAns = wrongAns;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Date getCreateData() {
		return createData;
	}
	public void setCreateData(Date createData) {
		this.createData = createData;
	}
	
}
