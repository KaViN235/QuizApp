package com.project.QuizApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.QuizApp.model.Question;

@Repository
public interface Questiondao extends JpaRepository<Question,Integer> {
	List<Question> findAllByCategory(String category);
	@Query(value ="SELECT * FROM question q where q.category =:category ORDER BY RAND() LIMIT :numQu",nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int numQu);


}
