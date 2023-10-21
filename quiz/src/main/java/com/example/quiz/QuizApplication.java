package com.example.quiz;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class QuizApplication {
	/** 구동 매서드. */
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args)
				.getBean(QuizApplication.class).execute();
	}

	/** 주입 */
	@Autowired
	QuizRepository repository;

	/** 실행 매서드 */
	private void execute() {
		// 등록 처리
		// setup();
		// showList();
		// showOne();
		// updateQuiz();
		deleteQuiz();
	}

	/** === 퀴즈 2건을 등록 === */
	private void setup() {
		// 엔티티 생성
		Quiz quiz1 = new Quiz(null, "Spirng은 프레임워크입니가?", true, "khs");

		// 등록 실행
		quiz1 = repository.save(quiz1);

		// 등록 확인
		System.out.println("등록한 퀴즈는 " + quiz1 + "입니다.");

		// 엔티티 생성
		Quiz quiz2 = new Quiz(null, "스프링 MVC는 배치 처리를 제공합니까?", false, "khs");
		// 등록 실행
		quiz2 = repository.save(quiz2);
		// 등록 확인
		System.out.println("등록한 퀴즈는" + quiz2 + "임!");
	}

	private void showList() {
		System.out.println("--- data 취득 개시 ---");
		// 리포지토리를 이용해 모든 데이터를 취득해서 결과를 반환
		Iterable<Quiz> quizzes = repository.findAll();
		for (Quiz quiz : quizzes) {
			System.out.println(quiz);
		}

		System.out.println("--- 모든 데이터 취득 완료 ---");
	}

	private void showOne() {
		System.out.println("--- 1건 취득 개시 ---");
		Optional<Quiz> quizOpt = repository.findById(1);

		// 반환값이 있는지 확인
		if (quizOpt.isPresent()) {
			System.out.println(quizOpt.get());
		} else {
			System.out.println("data x 임둥!");
		}
		System.out.println("--- 1건 취득 end ---");
	}

	private void updateQuiz() {
		System.out.println("--- change action start ---");
		// 변경할 엔티티를 생성
		Quiz quiz1 = new Quiz(1, "스프링은 프레임 워크?", true, "change manager");
		// 변경 처리
		quiz1 = repository.save(quiz1);
		// 변경 결과 확인
		System.out.println("변경한 데이터는 " + quiz1 + "입니다");
		System.out.println("--- changed end ---");
	}

	/** === 삭제 처리 === */
	private void deleteQuiz() {
		System.out.println("--- 삭제 처리 개시 ---");
		// 삭제 실행
		repository.deleteById(2);
		System.out.println("--- 삭제 처리 완료 ---");
	}

}
