package com.api.fortuna.model.repository;

import com.api.fortuna.model.domain.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {}
