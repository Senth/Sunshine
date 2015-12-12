package com.spiddekauga.sunshine;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection of weather data
 * @author Matteus Magnusson <matteus.magnusson@spiddekauga.com>
 */
public class WeatherCollection {
private final List<WeatherDayData> mDays = new ArrayList<>();

/**
 * Add another day to the weather data collection
 * @param day the day to add to the collection
 */
public void add(WeatherDayData day) {
	mDays.add(day);
}

/**
 * @return all weather info days as an array of strings
 */
public List<String> getAllInfos() {
	List<String> infos = new ArrayList<>();

	for (WeatherDayData day : mDays) {
		infos.add(day.getInfo());
	}

	return infos;
}

@Override
public String toString() {
	StringBuilder stringBuilder = new StringBuilder();

	for (WeatherDayData day : mDays) {
		stringBuilder.append(day.getInfo()).append("\n");
	}

	return stringBuilder.toString();
}
}
