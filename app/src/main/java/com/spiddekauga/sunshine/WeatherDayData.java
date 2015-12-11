package com.spiddekauga.sunshine;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Weather data for a specific day
 * @author Matteus Magnusson <matteus.magnusson@spiddekauga.com>
 */
public class WeatherDayData {
/**
 * Create a new weather data
 */
public WeatherDayData(int dayIndex, String day, String weatherType, double maxTemp, double minTemp) {
	StringBuilder stringBuilder = new StringBuilder();

	// Day
	if (dayIndex == 0) {
		stringBuilder.append("Today");
	} else if (dayIndex == 1) {
		stringBuilder.append("Tomorrow");
	} else {
		stringBuilder.append(day);
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

/** All information stored as string */
private String mInfo;

private static DecimalFormat mDecimalFormatter = new DecimalFormat("#");
}
