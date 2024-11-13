package com.souzaeverlan.dslist_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souzaeverlan.dslist_api.dto.GameListDTO;
import com.souzaeverlan.dslist_api.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameService;

	@GetMapping
	public List<GameListDTO> findAll() {
		return gameService.findAll();
	}
}
