package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StudentConfig {
	
	private final StudentRepository repository;
	
	public StudentConfig(StudentRepository repository) {
		this.repository=repository;
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args ->{
				Student Zayar = new Student(
						"Min Zayar Maung",
						"minzayarmaung2002@gmail.com",
						LocalDate.of(2002, Month.DECEMBER , 24)
						
			);
				Student Kyaw = new Student(
						"Kyaw Arkar Hein",
						"kyawarkarhein007.com",
						LocalDate.of(1998, Month.AUGUST , 2)
						
			);
			repository.saveAll(
					List.of(Zayar,Kyaw)
					);
		};
	}
}
