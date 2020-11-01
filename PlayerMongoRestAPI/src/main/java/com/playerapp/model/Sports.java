package com.playerapp.model;

public class Sports {

String sportName;
Integer yexperience;
public String getSportName() {
	return sportName;
}
public void setSportName(String sportName) {
	this.sportName = sportName;
}
public Integer getYexperience() {
	return yexperience;
}
public void setYexperience(Integer yexperience) {
	this.yexperience = yexperience;
}
@Override
public String toString() {
	return "Sports [sportName=" + sportName + ", yexperience=" + yexperience + "]";
}


}
