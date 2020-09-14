package com.ppo.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ppo.assignment.model.Student;
import com.ppo.assignment.repo.ContentJdbcRepository;
import com.ppo.assignment.repo.StudentJdbcRepository;
import com.ppo.assignment.service.ContentService;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentJdbcRepository repository;
	@Autowired
	ContentJdbcRepository contentJdbcRepository;
	@Autowired
	ContentService contentService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Student id 10001 -> {}", repository.findById(10001L));

		logger.info("Inserting -> {}", repository.insert(new Student(10010L, "John", "A1234657")));

		logger.info("Update 10003 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-Passport")));

		repository.deleteById(10002L);

		logger.info("All users -> {}", repository.findAll());
		
		logger.info("All content -> {}", contentJdbcRepository.findAll());
		
		logger.info("All content through service-> {}", contentService.getContentByMatchingTitle("title-", "0"));
	}
}
