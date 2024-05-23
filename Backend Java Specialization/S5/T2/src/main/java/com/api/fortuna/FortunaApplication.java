package com.api.fortuna;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import com.api.fortuna.model.domain.Player;
import com.api.fortuna.model.domain.enums.Roles;
import com.api.fortuna.model.service.PlayerServiceImplementation;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FortunaApplication {

	public static void main(String[] args) throws EntityPersistenceException {
		SpringApplication.run(FortunaApplication.class, args);
	}

}
