package com.project.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.QuizApp.model.Question;
import com.project.QuizApp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionService questionservice;
	@GetMapping("/allquestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionservice.getAllQuestion();
	}
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getByCategory(@PathVariable String category){
		return questionservice.getByCategory(category);
	}
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionservice.addquestion(question);
	}
	@PostMapping("delete/{id}")
	public ResponseEntity<String> DeleteQuestion(@PathVariable int id) {
		return questionservice.deletequestion(id);
	}
}
