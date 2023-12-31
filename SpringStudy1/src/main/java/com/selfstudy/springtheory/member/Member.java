package com.selfstudy.springtheory.member;

import org.springframework.stereotype.Component;

@Component
public class Member {
	
	private Long id;
	private String name;
	private Grade grade;
	
	public Member() {
		
	}
	
	public Member(long id, String name, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
	
	
}
