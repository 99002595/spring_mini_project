package com.playerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playerapp.dao.PlayerRepository;
import com.playerapp.exceptions.PlayerNotFoundException;
import com.playerapp.model.Player;
@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public Player getPlayerById(Integer playerId) throws PlayerNotFoundException{
		return playerRepository.findById(playerId)
				.orElseThrow(()->new PlayerNotFoundException("Player with specified id not found"));
	}

	@Override
	public Player addPlayer(Player player) {
		// TODO Auto-generated method stub
		Player newPlayer=playerRepository.save(player);
		return newPlayer;
	}

	@Override
	public Boolean deletePlayer(Integer playerid) throws PlayerNotFoundException{
		playerRepository.deleteById(playerid);
		return true;
	}

	@Override
	public List<Player> getPlayersBySportName(String sportName) throws PlayerNotFoundException {
		return playerRepository.findBySportsSportName(sportName);
		
	}

	@Override
	public List<Player> getPlayerByState(String playerState) throws PlayerNotFoundException {
		return playerRepository.findByplayerState(playerState);
	}

	@Override
	public List<Player> findPlayerByAge(Integer page)throws PlayerNotFoundException  {
		return playerRepository.findByAge(page);
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

}
