package com.tech.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Question")
public class Question {
	@Id
	@Column(name="QID")
	private Integer qId;
	
	@Column(name="QUESTION")
	private String question;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Answer answer;
	
	
	public Integer getqId() {
		return qId;
	}


	public void setqId(Integer qId) {
		this.qId = qId;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Answer getAnswer() {
		return answer;
	}


	public void setAnswer(Answer answer) {
		this.answer = answer;
	}


	public Question() {
		System.out.println("zero paramters with Question class...");
	}

}
