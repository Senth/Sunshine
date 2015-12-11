package com.spiddekauga.sunshine;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * Weather data for a specific day
 * @author Matteus Magnusson <matteus.magnusson@spiddekauga.com>
 */
public class WeatherDayData {
private static DecimalFormat mDecimalFormatter = new DecimalFormat("#");
/**
 * All information stored as string
 */
private String mInfo;

/**
 * Create a new weather data
 * @param dayIndex the index of the day
 * @param date what date the day is
 * @param weatherType what type of weather it is the specified day
 * @param minTemp minimum temperature the current day
 * @param maxTemp maximum temperature the current day
 */
public WeatherDayData(int dayIndex, Date date, String weatherType, double minTemp, double maxTemp) {
	StringBuilder stringBuilder = new StringBuilder();

	// Day
	if (dayIndex == 0) {
		stringBuilder.append("Today");
	} else if (dayIndex == 1) {
		stringBuilder.append("Tomorrow");
	} else {
		stringBuilder.append(date.toString());
	}
	stringBuilder.append(" — ");

	// Weather type
	stringBuilder.append(weatherType).append(" — ");

	// Temperatures
	stringBuilder.append(mDecimalFormatter.format(minTemp)).append("/");
	stringBuilder.append(mDecimalFormatter.format(maxTemp));

	mInfo = stringBuilder.toString();
}

/**
 * @return weather data for this specific day
 */
public String getInfo() {
	return mInfo;
}
}
