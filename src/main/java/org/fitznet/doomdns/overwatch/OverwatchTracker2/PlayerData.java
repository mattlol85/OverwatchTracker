package org.fitznet.doomdns.overwatch.OverwatchTracker2;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

public class PlayerData{
private boolean isPrivate;
private int endorsmentLevel;
private int playerLevel;
private URL profileIcon;
private int rating;
private int prestigeLevel;
private int gamesWon;
private URL prestiegeIcon;
private URL endorsmentIcon;
private String username;
private URL levelIcon;



    public PlayerData(JSONObject jsonData){
    //TODO Finish methods
    isPrivate = (boolean)jsonData.get("private");

    //jsonData.get("private").equals("false");
    /*
    System.out.println(jsonData.get("endorsement"));
    System.out.println(jsonData.get("icon"));
    System.out.println(jsonData.get("rating"));
    System.out.println(jsonData.get("ratingIcon"));
    System.out.println(jsonData.get("prestige"));
    System.out.println(jsonData.get("gamesWon"));
    System.out.println(jsonData.get("endorsementIcon"));
    System.out.println(jsonData.get("competitiveStats"));
    */
    
    
    }

    // No Argument, Defaults to my Data
    public PlayerData(){
        
    }

    //Getters TODO Finish writing getters
    //Returns true if private
    public boolean isPrivate(){return isPrivate;}
    public int getRating(){return rating;}
    public int getEndorsmentLevel(){return endorsmentLevel;}
    public int getPrestiegeLevel(){return prestigeLevel;}
    public URL getProfileIcon(){return profileIcon;}
    public URL getPrestiegeIcon(){return prestiegeIcon;}
    public String getUsername(){return username;}
}