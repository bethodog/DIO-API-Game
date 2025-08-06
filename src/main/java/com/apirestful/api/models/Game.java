package com.apirestful.api.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_game")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100)
	private String title;
	@Column(name = "game_year")
	private Integer gameYear;
	@OneToOne(cascade = CascadeType.ALL)
	private Genre genre;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Platform> platforms;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Language> languages;
	@Column(precision = 2)
	private Double score;
	private String imgUrl;
	
	@Column(columnDefinition = "TEXT", length = 100)
	private String shortDescription;

	@Column(columnDefinition = "TEXT", length = 255)
	private String longDescription;

}
