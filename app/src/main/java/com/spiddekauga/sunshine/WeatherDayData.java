package com.spiddekauga.sunshine;

import java.text.DecimalFormat;

/**
 * Weather data for a specific day
 * @author Matteus Magnusson <matteus.magnusson@spiddekauga.com>
 */
public class WeatherDayData {
private static final DecimalFormat mDecimalFormatter = new DecimalFormat("#");
/** All information stored as string */
private final String mInfo;

/**
 * Create a new weather data
 * @param day which day it is
 * @param weatherType what type of weather it is the specified day
 * @param minTemp minimum temperature the current day
 * @param maxTemp maximum temperature the current day
 */
public WeatherDayData(String day, String weatherType, double minTemp, double maxTemp) {
	String minTempString = mDecimalFormatter.format(minTemp);
	String maxTempString = mDecimalFormatter.format(maxTemp);
	mInfo = day + "  —  " + weatherType + "  —  " + minTempString + "/" + maxTempString;
}

/**
 * @return weather data for this specific day
 */
public String getInfo() {
	return mInfo;
}
}
