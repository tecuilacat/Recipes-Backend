package com.github.tequilacat.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.github.tequilacat.*"})
@EntityScan(basePackages = "com.github.tequilacat.*")
@EnableJpaRepositories(basePackages = {"com.github.tequilacat.*"})
public class RecipesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesApplication.class, args);
	}

}
