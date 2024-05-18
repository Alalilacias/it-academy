package com.api.fortuna.model.repository;

import com.api.fortuna.model.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {}