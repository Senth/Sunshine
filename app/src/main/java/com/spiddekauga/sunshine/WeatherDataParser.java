package com.spiddekauga.sunshine;

import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by senth on 2015-12-11.
 */
public class WeatherDataParser {
/**
 * Retrieves the maximum temperature for a specific date from an api call to openweathermap.
 * @param weatherJsonString the JSON string with weather data
 * @param dayIndex the day to get the max temperature from. Starts at 0
 * @return max temperature of the day.
 */
public static double getMaxTemperatureForDay(String weatherJsonString, int dayIndex) throws JSONException {
	JSONObject day = getDay(weatherJsonString, dayIndex);
	JSONObject temperature = day.getJSONObject("temp");
	return temperature.getDouble("max");
}

/**
 * Retreives the day of the weather string
 * @param weatherJsonString the JSON string with weather data
 * @param dayIndex the day to get the max temperature from
 * @return weather data for the specified date
 */
private static JSONObject getDay(String weatherJsonString, int dayIndex) throws JSONException {
	JSONObject jsonObject = new JSONObject(weatherJsonString);
	JSONArray days = jsonObject.getJSONArray("list");
	return days.getJSONObject(dayIndex);
}

}
