package org.fitznet.doomdns.overwatch.OverwatchTracker2;

import org.json.simple.JSONObject;

import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.parser.*;

public class PlayerData{
private boolean isProfilePrivate;
private int endorsmentLevel;
private URL profileIcon;
private int rating;
private int prestigeLevel;
private int gamesWon;
private URL prestiegeIcon;
private URL endorsmentIcon;
private String Username;
private URL levelIcon;



    public PlayerData(JSONObject jsonData){
    //TODO Finish methods
    if(jsonData.get("private").equals("false"))
    isProfilePrivate = false;
    else
    isProfilePrivate = true;
    endorsmentLevel = (int) jsonData.get("endorsement");
    }

    //No Argument, Defaults to my Data
    public PlayerData(){
        
    }
    public int getEndorsmentLevel(){
        return endorsmentLevel;
    }

}