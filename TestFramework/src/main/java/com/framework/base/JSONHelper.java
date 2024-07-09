package com.framework.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JSONHelper implements JSONUtils {

	String JSONString= StringUtils.EMPTY;
	JsonObject jsonObject;
	
	
	public JSONHelper(String dataJson) {
		
		this.JSONString= dataJson; 
		if(parseJson(this.JSONString).isJsonObject())
			jsonObject= (JsonObject) parseJson(this.JSONString);
		}
	
	public JSONHelper() {
		
		}

	public JSONObject getDataObject() {
		
		return new JSONObject(this.jsonObject.toString());
		
		
	}
	
	@Override
	public boolean isValidJSON(String jsonString) {
	
		try {
			parseJson(jsonString);
			return true;
		
		}catch (JsonSyntaxException e) {
			
			System.out.println("The given text is not valid JSON. Please check the JSON file"+ e.getStackTrace());
			return false;
			}
		}

	@Override
	public boolean isJSONArray(String jsonString) {
		
		try {
			
			return parseJson(jsonString).isJsonArray();
	
		}catch (JsonSyntaxException e){
			System.out.println("The given text is not valid JSON. Please check the JSON file"+ e.getStackTrace());
			return false;
			}
	}

	@Override
	public boolean isJSONObject(String jsonString) {
		try {
			
			return parseJson(jsonString).isJsonObject();
				
		}catch (JsonSyntaxException e){
			System.out.println("The given text is not valid JSON. Please check the JSON file"+ e.getStackTrace());
			return false;
			}
	}
	

	@Override
	public JSONArray getJSONArray(String key) {
		return new JSONArray (this.jsonObject.getAsJsonArray(key).toString()); 
		
	}

	@Override
	public JSONObject getJSONObject(String key) {
		return new JSONObject (this.jsonObject.getAsJsonObject(key).toString()); 
	}

	@Override
	public int getJSONArrayLength(JSONArray jsonArray) {
		return jsonArray.length();
	}

	/*
	@Override
	public Set<String> getAttributes(JSONObject jsonObject) {
	JsonObject gsonjsonObject= (JsonObject) new JsonParser().parse(jsonObject.toString());
	return gsonjsonObject.keySet();	
	
	}
*/
	@Override
	public  Map<String, String> getJSONData(JSONObject jsonObject) {
		
		JsonObject gsonjsonObject= (JsonObject) new JsonParser().parse(jsonObject.toString());
		Set<String> keys= getAttributes(jsonObject);
		Iterator<String> keyItr= keys.iterator();
		Map<String,String> JSONData= new HashMap<String,String>();
		
		while (keyItr.hasNext()){
			String key= keyItr.next();
			JSONData.put(key, gsonjsonObject.get(key).getAsString());
		}
		
		return JSONData;
		
	}
	
	private JsonElement parseJson(String jsonString) throws JsonSyntaxException {
		
		return new JsonParser().parse(jsonString);
		
	}
	
	@Override
	public <T> T getObject(String jsonString, Class<T> returnClass) {
		Gson gson= new GsonBuilder().create();
		return gson.fromJson(jsonString, returnClass);
		
	}

	@Override
	public Set<String> getAttributes(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
