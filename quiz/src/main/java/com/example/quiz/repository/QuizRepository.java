package com.example.quiz.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.quiz.entity.Quiz;

/** Quiz 테이블: RepositoryImpl */
public interface QuizRepository extends CrudRepository<Quiz, Integer> {

}