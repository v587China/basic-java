package com.ultra.java高级;

public class Student extends Person{
	public String id;
	protected String score;
	String course;
	private int grade;
	
	public Student() {
	}
	public Student(String course, int grade) {
		this.course = course;
		this.grade = grade;
		
	}
	private String getCourse() {
		return course;
	}
	private void setCourse(String course,Integer grade) {
		System.out.println(course);
		System.out.println(grade);
	}
	private int getGrade() {
		return grade;
	}
	private void setGrade(Integer grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", score=" + score + ", course=" + course
				+ ", grade=" + grade + "]";
	}
	
}
