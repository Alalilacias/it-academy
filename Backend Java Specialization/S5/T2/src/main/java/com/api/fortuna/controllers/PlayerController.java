package com.api.fortuna.controllers;

import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.api.fortuna.configuration.Constants.Controllers.Players.MAPPING;

/**
 * TODO finish and test.
 */
@RestController
@RequestMapping(MAPPING)
public class PlayerController {
    @Autowired
    private PlayerService service;

    public PlayerDTO creatPlayer(@RequestBody ClientAuthRequest request){
        return service.create(request);
    }
}
