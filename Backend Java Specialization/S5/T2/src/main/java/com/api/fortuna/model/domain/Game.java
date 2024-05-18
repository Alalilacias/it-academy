package com.api.fortuna.model.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.concurrent.ThreadLocalRandom;

/**
 *  This class represents a single game in the system.
 *  Uses Lombok annotations for boilerplate code reduction and JPA annotations for database mapping.
 *  TODO Finish class and testing.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@Document(collection = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private long playerID;
    private int ocassio;
    private int poena;

    public Game(long playerID){
        this.playerID = playerID;
        ocassio = ThreadLocalRandom.current().nextInt(1,7);
        poena = ThreadLocalRandom.current().nextInt(1,7);
    }
}
