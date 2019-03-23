package com.hp.onlinexam.po;
/**
 * 这是题库类，是题目的集合
 * @author duye
 *
 */
public class Question {
	//问题的唯一标识
	private int id;
	//问题所属课程id
	private int courseId;
	//问题类型，如1表示单选
	private int queType;
	//问题题干
	private String queTitle;
	//四个选项
	private String choiceA;
	private String choiceB;
	private String choiceC;
	private String choiceD;
	//正确答案
	private String ans;
	//标识题库中这个题是删除了还是没删除，默认是存在的，当删除的时候改变状态
	private int queExist = 1;
	public Question() {

	}

	public Question(int courseId, int queType, String queTitle, String choiceA, String choiceB, String choiceC,
			String choiceD, String ans) {
		this.courseId = courseId;
		this.queType = queType;
		this.queTitle = queTitle;
		this.choiceA = choiceA;
		this.choiceB = choiceB;
		this.choiceC = choiceC;
		this.choiceD = choiceD;
		this.ans = ans;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getQueType() {
		return queType;
	}
	public void setQueType(int queType) {
		this.queType = queType;
	}
	public String getQueTitle() {
		return queTitle;
	}
	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}
	public String getChoiceA() {
		return choiceA;
	}
	public void setChoiceA(String choiceA) {
		this.choiceA = choiceA;
	}
	public String getChoiceB() {
		return choiceB;
	}
	public void setChoiceB(String choiceB) {
		this.choiceB = choiceB;
	}
	public String getChoiceC() {
		return choiceC;
	}
	public void setChoiceC(String choiceC) {
		this.choiceC = choiceC;
	}
	public String getChoiceD() {
		return choiceD;
	}
	public void setChoiceD(String choiceD) {
		this.choiceD = choiceD;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public int getQueExist() {
		return queExist;
	}
	public void setQueExist(int queExist) {
		this.queExist = queExist;
	}

	
}
