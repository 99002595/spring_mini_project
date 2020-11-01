package com.playerapp.service;

import java.util.List;

import com.playerapp.exceptions.PlayerNotFoundException;
import com.playerapp.model.Player;

public interface PlayerService {
Player getPlayerById(Integer playerid)throws PlayerNotFoundException ;
Player addPlayer(Player player);
Boolean deletePlayer(Integer id)throws PlayerNotFoundException ;
List<Player> getAllPlayers();
List<Player> getPlayersBySportName(String sportName)throws PlayerNotFoundException ;
List<Player> getPlayerByState(String playerState)throws PlayerNotFoundException ;
List<Player> findPlayerByAge(Integer page)throws PlayerNotFoundException ;
}
