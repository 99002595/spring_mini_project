package com.playerapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="player")
@TypeAlias("Player")
public class Player {
	@Id
Integer playerId;
String playername;
String playerState;
Integer page;
Sports sports;
public Integer getPlayerId() {
	return playerId;
}
public void setPlayerId(Integer playerId) {
	this.playerId = playerId;
}
public String getPlayername() {
	return playername;
}
public void setPlayername(String playername) {
	this.playername = playername;
}
public String getPlayerState() {
	return playerState;
}
public void setPlayerState(String playerState) {
	this.playerState = playerState;
}
public Integer getPage() {
	return page;
}
public void setPage(Integer page) {
	this.page = page;
}
public Sports getSports() {
	return sports;
}
public void setSports(Sports sports) {
	this.sports = sports;
}
@Override
public String toString() {
	return "Student [playerId=" + playerId + ", playername=" + playername + ", playerState=" + playerState + ", page="
			+ page + "]";
}


}
