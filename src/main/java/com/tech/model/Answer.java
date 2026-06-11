package com.tech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Answer {
	@Id
	@Column(name="AID")
	private Integer aId;
	
	@Column(name="ANSWER")
	private String answer;
	
	

	public Integer getaId() {
		return aId;
	}



	public void setaId(Integer aId) {
		this.aId = aId;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public Answer() {
		System.out.println("zero parameter of answer class....");
	}

}
