package com.project.QuizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.QuizApp.dao.Questiondao;
import com.project.QuizApp.dao.QuizDao;
import com.project.QuizApp.model.Question;
import com.project.QuizApp.model.QuestionWrapper;
import com.project.QuizApp.model.Quiz;
import com.project.QuizApp.model.Response;

@Service
public class QuizService {
	@Autowired
	QuizDao quizdao;
	@Autowired
	Questiondao questiondao;

	public ResponseEntity<String> createQuiz(String category, int numQu, String title) {
		List<Question> questions = questiondao.findRandomQuestionsByCategory(category,numQu);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizdao.save(quiz);
		System.out.println(questions);
		return new ResponseEntity<>("wow done",HttpStatus.OK);
	}

	public ResponseEntity<QuestionWrapper> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizdao.findById(id);
		List<Question> quesFromDb = quiz.get().getQuestions();
		List<QuestionWrapper> quesForUser = new ArrayList<>();
		for(Question q : quesFromDb ) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3());
			quesForUser.add(qw);		
		}
		return new ResponseEntity(quesForUser,HttpStatus.FOUND);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) { 
		Quiz quiz = quizdao.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int right =0;
		int i=0;
		for(Response response : responses) {
			if(response.getResponse().equals(questions.get(i).getRight_answer())) {
				right++;
			}
			i++;
			}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

}
