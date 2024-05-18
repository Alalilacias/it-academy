package com.api.fortuna.model.service;

import com.api.fortuna.model.repository.GameRepository;
import com.api.fortuna.model.service.interfaces.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImplementation implements GameService {
    @Autowired
    private GameRepository repository;
}
