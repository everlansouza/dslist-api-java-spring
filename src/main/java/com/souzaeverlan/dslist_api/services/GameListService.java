package com.souzaeverlan.dslist_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.souzaeverlan.dslist_api.dto.GameListDTO;
import com.souzaeverlan.dslist_api.entities.GameList;
import com.souzaeverlan.dslist_api.projections.GameMinProjection;
import com.souzaeverlan.dslist_api.repositories.GameListRepository;
import com.souzaeverlan.dslist_api.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();

		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

	@Transactional
	public void move(Long listId, int sourceIndex, int destinatinIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);

		list.add(destinatinIndex, obj);

		int min = sourceIndex < destinatinIndex ? sourceIndex : destinatinIndex;
		int max = sourceIndex < destinatinIndex ? destinatinIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
