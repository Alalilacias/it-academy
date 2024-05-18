package com.api.fortuna.model.domain;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.concurrent.ThreadLocalRandom;

/**
 *  This class represents a single game in the system.
 *  Uses Lombok annotations for boilerplate code reduction and JPA annotations for database mapping.
 */
@Getter
@NoArgsConstructor
@Document(collection = "games")
public class Game {
    /**
     * The unique identifier for the game. Automatically generated by the database.
     */
    @Id
    private String id;

    /**
     * The unique identifier for the player, taken from the player class during game creation in the service layer and passed through constructor.
     */
    private long playerID;

    /**
     * The two dices, named after two temples dedicated to the worship of the name holder of our app.
     */
    private int muliebris;
    private int primigenia;

    public Game(long playerID){
        this.playerID = playerID;
        this.muliebris = ThreadLocalRandom.current().nextInt(1,7);
        this.primigenia = ThreadLocalRandom.current().nextInt(1,7);
    }
}