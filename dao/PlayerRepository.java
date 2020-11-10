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
	//List<Player> findByplayerStateAndSportsSportName(String playerState,String sportsName);
	@Query("from Sports s where s.sportsName=?1 and s.yexperience=?2")
	List<Player> findBySportsSportNameAndyexperience(String sportsName,Integer yexperience);
	List<Player> findBySportsYexperience(Integer yexperience);
	@Query("{'age':{$gt:?0}}")
	List<Player> findByAge(Integer age);

}
