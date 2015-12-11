package com.spiddekauga.sunshine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Parses weather data from the open weather data API
 * @author Matteus Magnusson <matteus.magnusson@spiddekauga.com>
 */
public class WeatherDataParser {
private static final String TIME = "dt";
private static final String DAYS = "list";
private static final String TEMPERATURES = "temp";
private static final String TEMP_MIN = "min";
private static final String TEMP_MAX = "max";
private static final String WEATHER_INFO = "weather";
private static final String WEATHER_TYPE = "main";

/**
 * Convert the weather API JSON string into weather day data objects
 * @param weatherJson the JSON string with weather data
 * @return all days containing weather data
 */
public static List<WeatherDayData> toWeatherDayData(String weatherJson) throws JSONException {
	JSONObject jsonObject = new JSONObject(weatherJson);
	JSONArray days = jsonObject.getJSONArray(DAYS);

	List<WeatherDayData> data = new ArrayList<>();
	for (int i = 0; i < days.length(); ++i) {
		JSONObject day = days.getJSONObject(i);

		int epochTime = day.getInt(TIME);
		Date date = new Date(epochTime);
		JSONObject temperatures = day.getJSONObject(TEMPERATURES);
		double minTemp = temperatures.getDouble(TEMP_MIN);
		double maxTemp = temperatures.getDouble(TEMP_MAX);
		JSONObject weatherInfo = day.getJSONObject(WEATHER_INFO);
		String weatherType = weatherInfo.getString(WEATHER_TYPE);

		WeatherDayData weatherDayData = new WeatherDayData(i, date, weatherType, minTemp, maxTemp);
		data.add(weatherDayData);
	}

	return data;
}
}
