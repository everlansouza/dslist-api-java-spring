package com.souzaeverlan.dslist_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.souzaeverlan.dslist_api.dto.GameListDTO;
import com.souzaeverlan.dslist_api.entities.GameList;
import com.souzaeverlan.dslist_api.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();

		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
