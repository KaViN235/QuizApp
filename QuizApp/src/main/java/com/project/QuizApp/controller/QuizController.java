package com.project.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.QuizApp.model.QuestionWrapper;
import com.project.QuizApp.model.Response;
import com.project.QuizApp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizservice; 
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam("numQ")int numQu,@RequestParam String title){
		return quizservice.createQuiz(category,numQu,title);  
	} 
	
	@GetMapping("get/{id}")
	public ResponseEntity<QuestionWrapper> getQuizQuestions(@PathVariable Integer id){
		return quizservice.getQuizQuestions(id);  
	} 
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> calculateResult(@PathVariable Integer id,@RequestBody List<Response> responses){
		return quizservice.calculateResult(id,responses);
		
	}

}
