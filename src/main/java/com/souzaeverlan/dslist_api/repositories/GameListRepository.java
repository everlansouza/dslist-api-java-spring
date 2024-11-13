package com.souzaeverlan.dslist_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.souzaeverlan.dslist_api.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
