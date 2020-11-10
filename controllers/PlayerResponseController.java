package com.playerapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/player-api")
public class PlayerResponseController {

	@Autowired
	PlayerService playerService;
	@PostMapping("/players")
	 ResponseEntity<Player> addPlayer(@RequestBody Player player)
	 {
		Player nPlayer=playerService.addPlayer(player);
		return ResponseEntity.ok(nPlayer);
	 }
	@DeleteMapping("/players/delete-one/{playerId}")
	ResponseEntity<Void> deletePlayer(@PathVariable("playerId")  Integer playerId) throws PlayerNotFoundException
	 {
		 playerService.deletePlayer(playerId);
		 return ResponseEntity.status(HttpStatus.OK).build();
	 }
	@GetMapping("/players/get-one/{playerId}")
	ResponseEntity<Player> getPlayerById(@PathVariable("playerId") Integer playerId) throws PlayerNotFoundException
	 {
		Player nPlayer=playerService.getPlayerById(playerId);
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "Getting Player By Id");
		header.add("title", "One Player");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(nPlayer);
	 }
	
	 @GetMapping("/players")
	 ResponseEntity<List<Player>> getAllPlayers()
	 {
		 List<Player> playerList=playerService.getAllPlayers();
		 return ResponseEntity.ok(playerList);
	 }
	 @GetMapping("/players/playerState/{playerState}")
	 ResponseEntity<List<Player>> getPlayertbyState(@PathVariable("playerState")String playerState) throws PlayerNotFoundException{
	        List<Player> playerList =   playerService.getPlayerByState(playerState);
	        return ResponseEntity.ok(playerList);
	    }
	 @GetMapping("/players/page/{page}")
	 ResponseEntity<List<Player>> getPlayerbyAge(@PathVariable("page")Integer page)throws PlayerNotFoundException{
	        List<Player> playerList = playerService.findPlayerByAge(page);    
	        return ResponseEntity.ok(playerList);
	    }
	@GetMapping("/players/sports/{sportName}")
	 public ResponseEntity<List<Player>> findSportsBySportName(@PathVariable("sportName")String sportName) {
	        List<Player> playerList = playerService.getPlayersBySportName(sportName);
	        return ResponseEntity.ok(playerList);
	        
	    }
	@GetMapping("/players/sportsyear/{yexperience}")
	 public ResponseEntity<List<Player>> findSportsByyeraofexperince(@PathVariable("yexperience")Integer yexperience) {
	        List<Player> playerList = playerService.getByYearofExperince(yexperience);
	        return ResponseEntity.ok(playerList);
	        
	    }
	@GetMapping("/players/sportsyear/{sportsName}/{yexperience}")
	 public ResponseEntity<List<Player>> getBySportsSportNameAndyexperience(@PathVariable("sportsName")String sportsName,@PathVariable("yexperience")Integer yexperience) {
	        List<Player> playerList = playerService.getBySportsSportNameAndyexperience(sportsName, yexperience);
	        return ResponseEntity.ok(playerList);
	        
	    }
	
}
