package com.spiddekauga.sunshine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Parses weather data from the open weather data API
 * @author Matteus Magnusson <matteus.magnusson@spiddekauga.com>
 */
public class WeatherDataParser {
private static final String DAYS = "list";
private static final String TEMPERATURES = "temp";
private static final String TEMP_MIN = "min";
private static final String TEMP_MAX = "max";
private static final String WEATHER_INFO = "weather";
private static final String WEATHER_TYPE = "main";
private static final SimpleDateFormat mDateFormatter = new SimpleDateFormat("EEEE");

/**
 * Convert the weather API JSON string into weather day data objects
 * @param weatherJson the JSON string with weather data
 * @return all days containing weather data
 */
public static WeatherCollection toWeatherCollection(String weatherJson) throws JSONException {
	JSONObject jsonObject = new JSONObject(weatherJson);
	JSONArray days = jsonObject.getJSONArray(DAYS);

	GregorianCalendar calendar = new GregorianCalendar();
	calendar.add(GregorianCalendar.DATE, -1);

	WeatherCollection weatherCollection = new WeatherCollection();
	for (int i = 0; i < days.length(); ++i) {
		JSONObject day = days.getJSONObject(i);

		JSONObject temperatures = day.getJSONObject(TEMPERATURES);
		double minTemp = temperatures.getDouble(TEMP_MIN);
		double maxTemp = temperatures.getDouble(TEMP_MAX);
		JSONArray weatherInfos = day.getJSONArray(WEATHER_INFO);
		JSONObject weatherInfo = weatherInfos.getJSONObject(0);
		String weatherType = weatherInfo.getString(WEATHER_TYPE);

		// Day
		calendar.add(GregorianCalendar.DATE, 1);
		String dayName;
		if (i == 0) {
			dayName = "Today";
		} else if (i == 1) {
			dayName = "Tomorrow";
		} else {
			Date date = calendar.getTime();
			dayName = mDateFormatter.format(date);
		}

		WeatherDayData weatherDayData = new WeatherDayData(dayName, weatherType, minTemp, maxTemp);
		weatherCollection.add(weatherDayData);
	}

	return weatherCollection;
}
}
