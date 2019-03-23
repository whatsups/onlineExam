package com.hp.onlinexam.po;

/**
 * 连接 老师id 老师课程id 班级的适配器
 * @author duye
 *
 */
public class TeacherCourse {
	private int id;
	//老师的id
	private int teaId;
	//课程id
	private int courseId;
	//班级id
	private int classId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
}
