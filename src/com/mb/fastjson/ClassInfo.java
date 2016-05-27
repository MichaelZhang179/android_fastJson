package com.mb.fastjson;

import java.util.List;

public class ClassInfo {

	private String id;
	private String name;
	private List<StudentInfo> students;
	
	public ClassInfo() {
		super();
	}
	public ClassInfo(String id, String name, List<StudentInfo> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<StudentInfo> getStudents() {
		return students;
	}
	public void setStudents(List<StudentInfo> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "ClassInfo [id=" + id + ", name=" + name + ", students="
				+ students.toString() + "]";
	}
	
}
