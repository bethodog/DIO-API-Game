package com.apirestful.api.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.apirestful.api.dtos.GameDto;

public interface GameService {
	
	@Transactional(readOnly = true)
	List<GameDto> findAll();
	
	@Transactional(readOnly = true)
	GameDto findById(Long id);
	
	@Transactional
	GameDto gameToCreate(GameDto game);
	
	@Transactional
	void deleteGame(Long id);
	
	@Transactional
	GameDto gameToUpdate(GameDto game);

}
