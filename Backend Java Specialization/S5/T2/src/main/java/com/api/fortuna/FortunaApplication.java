package com.api.fortuna;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FortunaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortunaApplication.class, args);
	}

}