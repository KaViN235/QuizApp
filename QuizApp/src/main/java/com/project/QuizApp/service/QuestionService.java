package com.project.QuizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.QuizApp.dao.Questiondao;
import com.project.QuizApp.model.Question;

@Service
public class QuestionService {
	@Autowired
	Questiondao questiondao;
	public ResponseEntity<List<Question>> getAllQuestion() {	
		
	try {
		return new ResponseEntity(questiondao.findAll(),HttpStatus.OK);
	} catch (Exception e) {
		e.printStackTrace();
	}	
	return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Question>> getByCategory(String category) {
		
		try {
			return new ResponseEntity(questiondao.findAllByCategory(category), HttpStatus.OK) ;
		} catch (Exception e) {
			e.printStackTrace();
		}	return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<String> addquestion(Question question) {
		questiondao.save(question);
		return new ResponseEntity<>("Successfully added...",HttpStatus.CREATED);
	}
	public ResponseEntity<String> deletequestion(int id) {
		questiondao.deleteById(id);
		return new ResponseEntity<>("Successfully Deleted",HttpStatus.ACCEPTED);
	}

}
