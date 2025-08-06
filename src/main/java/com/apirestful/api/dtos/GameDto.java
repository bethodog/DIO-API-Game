package com.apirestful.api.dtos;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.apirestful.api.models.Game;
import com.apirestful.api.models.Genre;
import com.apirestful.api.models.Language;
import com.apirestful.api.models.Platform;

import lombok.Data;

@Data
public class GameDto {
	
	private Long id;
	private String title;
	private Integer gameYear;
	private Genre genre;
	private List<Platform> platforms;
	private List<Language> languages;
	private Double score;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;
	
	public GameDto() {
	}
	
	public GameDto(Game entity) {
		BeanUtils.copyProperties(entity, this);
	}

}
