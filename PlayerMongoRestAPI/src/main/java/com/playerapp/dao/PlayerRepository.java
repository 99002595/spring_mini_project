package com.playerapp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.playerapp.model.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, Integer> {
	List<Player> findBySportsSportName(String sportName);
	List<Player> findByplayerState(String playerState);
	@Query("{'age':{$gt:?0}}")
	List<Player> findByAge(Integer age);

}
