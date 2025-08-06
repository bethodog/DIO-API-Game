package com.apirestful.api.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirestful.api.dtos.GameDto;
import com.apirestful.api.models.Game;
import com.apirestful.api.repositories.GameRepository;
import com.apirestful.api.services.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<GameDto> findAll() {
		List<Game> games = repository.findAll();
		return games.stream().map(GameDto::new).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public GameDto findById(Long id) {
		Game game = repository.findById(id).orElseThrow(NoSuchElementException::new); 
		return new GameDto(game);
	}

	@Override
	@Transactional
	public GameDto gameToCreate(GameDto gameDto) {
		if(gameDto.getId() != null && repository.existsByTitle(gameDto.getTitle())) {
			throw new IllegalArgumentException("Esse game ja existe!"); 
		}
		
		Game entity = new Game();
		entity.setTitle(gameDto.getTitle());
		entity.setGameYear(gameDto.getGameYear());
		entity.setGenre(gameDto.getGenre());
		entity.setPlatforms(gameDto.getPlatforms());
		entity.setLanguages(gameDto.getLanguages());
		entity.setImgUrl(gameDto.getImgUrl());
		entity.setScore(gameDto.getScore());
		entity.setShortDescription(gameDto.getShortDescription());
		entity.setLongDescription(gameDto.getLongDescription());
		
		repository.save(entity);
		return new GameDto(entity);
	}

	@Override
	@Transactional
	public void deleteGame(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public GameDto gameToUpdate(GameDto gameDto) {
		
		Game gameSaved = repository.findById(gameDto.getId()).orElseThrow(NoSuchElementException::new);
		gameSaved.setGameYear(gameDto.getGameYear());
		gameSaved.setImgUrl(gameDto.getImgUrl());
		gameSaved.setTitle(gameDto.getTitle());
		gameSaved.setShortDescription(gameDto.getShortDescription());
		gameSaved.setLongDescription(gameDto.getLongDescription());
		gameSaved.setGenre(gameDto.getGenre());
		gameSaved.setPlatforms(gameDto.getPlatforms());
		gameSaved.setLanguages(gameDto.getLanguages());
		
		repository.saveAndFlush(gameSaved);
		return new GameDto(gameSaved);
	}

}
