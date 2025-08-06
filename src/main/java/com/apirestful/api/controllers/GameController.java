package com.apirestful.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apirestful.api.dtos.GameDto;
import com.apirestful.api.services.GameService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameService service;
	
	@GetMapping
	@Operation(summary = "Busca todos os games", description = "Faz a busca dos games em toda base de dados")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Retorno de todos os games"),
			@ApiResponse(responseCode = "500", description = "Erro na requisição")
	})
	public ResponseEntity<List<GameDto>> findAll() {
		var dto = service.findAll();
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Busca game", description = "Faz a busca de um unico games por ID")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Retorno do games"),
			@ApiResponse(responseCode = "500", description = "Erro na requisição")
	})
	public ResponseEntity<GameDto> findById(@PathVariable Long id) {
		var dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	@Operation(summary = "Cria um game", description = "Faz a criação de um game")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Game criado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro na requisição")
	})
	public ResponseEntity<GameDto> create(@RequestBody GameDto body){
		var dto = service.gameToCreate(body);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(location).body(dto);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta o game", description = "Faz a busca exclusão do game por ID")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Deletado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro na requisição")
	})
	public ResponseEntity<GameDto> deleteById(@PathVariable Long id) {
		service.deleteGame(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	@Operation(summary = "Atualiza o game", description = "Faz a atualização do game")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Game atualizado com sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro na requisição")
	})
	public ResponseEntity<GameDto> findById(@RequestBody GameDto body) {
		var dto = service.gameToUpdate(body);
		return ResponseEntity.ok(dto);
	}

}
