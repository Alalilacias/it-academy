package com.api.fortuna.model.dto.requests;

import com.api.fortuna.model.domain.Player;

import static com.api.fortuna.configuration.Constants.Controllers.Players.ANONYMOUS;

/**
 * TODO finish and test.
 */
public record ClientAuthRequest(String username, String email, String password) {
    public Player toPlayer(){
        if(username.isBlank() || username.isEmpty()){
            return Player.builder()
                    .username(ANONYMOUS)
                    .email(email)
                    .password(password)
                    .build();
        }
        return Player.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();
    }
}
