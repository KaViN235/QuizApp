package com.project.QuizApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class QuestionWrapper {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String question_title;
	private String option1;
    private String option2;
    private String option3;
	public QuestionWrapper(Integer id, String question_title, String option1, String option2, String option3) {
		super();
		this.id = id;
		this.question_title = question_title;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
	}
    
}
