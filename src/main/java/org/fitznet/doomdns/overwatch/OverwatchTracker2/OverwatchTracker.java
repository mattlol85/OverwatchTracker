package org.fitznet.doomdns.overwatch.OverwatchTracker2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class OverwatchTracker {

	public static void main(String[] args) {
		// Temporary
		String username = "Mattlol85-1435";
		String platform = "pc";
		String region = "us";

		JSONObject playerJson = getJsonFromString(requestData(username, platform, region));
		prettyPrintJson(playerJson);
		//writeJSONdata(getPrettyJson(playerData));
		PlayerData testPlayerdata = new PlayerData(playerJson);
		//System.out.println(testPlayerdata.getEndorsmentLevel());
		//DO PLAYERDATA TESTING!!!!!!!!!!!!!!!
		//System.out.println(PlayerData.getEndorsmentLevel());
		/**
		 * -------GAME PLAN------
		 * 1) Get JSON files working right
		 * -Get JSON to print pretty
		 * -Find a storage method for JSON
		 * 
		 * 
		 * 2) Get a GUI up and running
		 * -GUI must ask for user Information (Region, platform and Username)
		 * -Display ranking information with Images
		 * -Show stats before and After a game showing differences
		 * 
		 * 3) Work out Comparison Logic
		 * -Graphically show preformance data
		 * -Refresh every 5? mins for accurate data
		 * 
		 */
	}
	/**
	 * Takes a string in JSON format, and provided that it is NOT empty, it returns a 
	 * JSON object
	 * 
	 * @param jsonAsString - String containing JSON formatted data
	 * @return JSONObject contatining the string information
	 */
	private static JSONObject getJsonFromString(String jsonAsString) {

		JSONObject jsonObject = new JSONObject();
		JSONParser jp = new JSONParser();
		if (jsonAsString != null) {

			try {

				jsonObject = (JSONObject) jp.parse(jsonAsString);
				return jsonObject;
			} catch (ParseException e) {

				e.printStackTrace();
			}
		} else {
			// Probably bad
			return null;
		}
		// Probably Terrible
		return null;
	}

	/**
	 * 
	 * @param username - Username on Overwatch
	 * @param platform - Platform to preform search upon. Options are pc, ps4 and
	 *                 xbox. Note BattleNet tags '#' are replaced with a '-'
	 * @param region   - us, eu, or asia
	 * @return String containing JSON data returned from ow-api.com information
	 */
	private static String requestData(String username, String platform, String region) {

		try {
			URL apiUrl = new URL(
					"https://ow-api.com/v1/stats/" + platform + "/" + region + "/" + username + "/profile");
			HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();
			System.out.println("Response Code:" + responseCode);
			// Read Data from stream
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String output;
			StringBuffer response = new StringBuffer();

			while ((output = in.readLine()) != null) {
				response.append(output);

			}
			String responseOutputInJsonFormat = response.toString();
			in.close();
			return responseOutputInJsonFormat;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// If all else fails, return NULL
		return null;
	}

	private static void writeJSONdata(JSONObject jsonData) {
		String jsonString = jsonData.toString();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		gson.toJson(jp.parse(jsonString));
		try {
			PrintWriter writer = new PrintWriter("PrettyJson.json");
			writer.write(jsonString);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method writes JSON data to the console in a pretty format
	 * 
	 * @param jsonData
	 */
	private static void prettyPrintJson(JSONObject jsonData) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); 		//Set the printing to be pretty
		JsonParser jp = new JsonParser();									//Create a JSON parser
		System.out.println(gson.toJson(jp.parse(jsonData.toString())));		//Return a pretty JSON String
	}

	private static JSONObject getPrettyJson(JSONObject jsonData){
	Gson gson = new GsonBuilder().setPrettyPrinting().create();				//Set the printing to be pretty
	JsonParser jp = new JsonParser();
	String prettyString = gson.toJson(jp.parse(jsonData.toJSONString()));										//Create a JSON parser
	JSONObject prettyJsonObject = getJsonFromString(prettyString);			//Create new JSON object from pretty string
	return prettyJsonObject;
	}
}
