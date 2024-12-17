package com.techbrothers3.test;


import com.techbrothers3.test.Model.QuizUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.techbrothers3.test.Model.Question;
import com.techbrothers3.test.Repository.QuestionRepository;
import com.techbrothers3.test.Repository.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class QuizAppApplication implements CommandLineRunner {
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		//seeding some questions
		questionRepository.saveAll(Arrays.asList(
				new Question("Who wrote Harry Potter", "J.K Rowling", Arrays.asList("Shakespeare", "Dickens", "Austen", "J.K Rowling")),
				new Question("What is 2+2?", "4", Arrays.asList("3","11","22","4")),
				new Question("What is the Capital of India","New Delhi",Arrays.asList("kolkata","bengaluru","hyderabad","New Delhi"))
		));

		// seeding a single user
		userRepository.save(new QuizUser("testUser"));
	}

}
