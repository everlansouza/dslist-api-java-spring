package com.souzaeverlan.dslist_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.souzaeverlan.dslist_api.dto.GameDTO;
import com.souzaeverlan.dslist_api.dto.GameMinDTO;
import com.souzaeverlan.dslist_api.entities.Game;
import com.souzaeverlan.dslist_api.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();

		return new GameDTO(result);
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();

		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
