package com.souzaeverlan.dslist_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.souzaeverlan.dslist_api.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
