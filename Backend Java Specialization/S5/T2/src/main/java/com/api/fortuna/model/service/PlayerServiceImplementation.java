package com.api.fortuna.model.service;

import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;
import com.api.fortuna.model.repository.PlayerRepository;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO finish and test.
 */
@Service
public class PlayerServiceImplementation implements PlayerService {
    @Autowired
    private PlayerRepository repository;

    @Override
    public PlayerDTO create(ClientAuthRequest request) {
        return repository.save(request.toPlayer()).toDTO();
    }
}
