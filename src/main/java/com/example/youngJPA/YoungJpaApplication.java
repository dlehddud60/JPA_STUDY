package com.example.youngJPA;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YoungJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoungJpaApplication.class, args);
	}
	@Bean
	JPAQueryFactory jpaQueryFactory (EntityManager em) {
		return new JPAQueryFactory(em);
	}
}
