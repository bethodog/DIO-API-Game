package com.apirestful.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirestful.api.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
