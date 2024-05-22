package com.api.fortuna.controllers;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private PlayerService service;

    /**
     * Returns a List with DTO representation of all Players in the system.
     *
     * @return A List of Player DTOs, empty if there's none.
     * @throws EntityPersistenceException If there's any issue with extracting the players from the database.
     * @see PlayerService#getAll()
     */
    @GetMapping("/getAll")
    public List<PlayerDTO> getAllPlayers() throws EntityPersistenceException {
        return service.getAll();
    }

    public boolean deletePlayer(long id){
        return service.deletePlayer(id);
    }
}
