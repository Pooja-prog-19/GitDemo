package com.framework.base;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;


public interface JSONUtils {
	
	public boolean isValidJSON(String jsonString);
	public JSONObject getDataObject();
	public boolean isJSONArray(String jsonString);
	public boolean isJSONObject(String jsonString);
	public JSONArray getJSONArray(String key);
	public JSONObject getJSONObject(String key);
	public int getJSONArrayLength(JSONArray jsonArray);
	public Set<String> getAttributes(JSONObject jsonObject);
	public <T> Map<String,T> getJSONData(JSONObject jsonObject);
	public <T extends Object> T getObject (String jsonString, Class<T> returnClass);
	
}
