package com.playerapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playerapp.exceptions.PlayerNotFoundException;
import com.playerapp.model.Player;
import com.playerapp.service.PlayerService;


public class PlayerController {
	@Autowired
	PlayerService playerService;
	@PostMapping("/players")
	Player addPlayer(@RequestBody Player player) {
	return playerService.addPlayer(player);	
	}
	@GetMapping("/players")
	List<Player> getAllPlayers(){
		return playerService.getAllPlayers();
	}
	@DeleteMapping("/players/delete-one/{playerId}")
	boolean deletePlayer(@PathVariable("playerId")Integer playerId) throws PlayerNotFoundException {
		return playerService.deletePlayer(playerId);
	}
	@GetMapping("/players/get-one/{playerId}")
	Player getStudentById(@PathVariable("playerId")Integer playerId) throws PlayerNotFoundException {
		return playerService.getPlayerById(playerId);
	}
	
	@GetMapping("/players/playerState/{playerState}")
	List<Player> getPlayerByState(@PathVariable("playerState")String playerState) throws PlayerNotFoundException{
		return playerService.getPlayerByState(playerState);
	}
	@GetMapping("/players/sportName/{sportName}")
	List<Player> getPlayerBySportName(@PathVariable("sportName")String sportName) throws PlayerNotFoundException{
		return playerService.getPlayersBySportName(sportName);
	}
	
	@GetMapping("/players/page/{page}")
	List<Player> getPlayerByAge(@PathVariable("page")Integer page) throws PlayerNotFoundException{
		return playerService.findPlayerByAge(page);
	}
	@GetMapping("/players/sportsName&Yexpierence/{sportsName}/{yexperience}")
	List<Player> findBySportsSportNameAndyexperience(@PathVariable("sportsName")String sportName,@PathVariable("yexperience")Integer yexperince) throws PlayerNotFoundException{
		return playerService.getBySportsSportNameAndyexperience(sportName,yexperince);
	}
	
}
