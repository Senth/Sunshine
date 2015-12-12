package com.spiddekauga.sunshine;

/**
 * Latitude and Longitude location for API calls
 * Created by senth on 2015-11-27.
 */
public class Location {
/** Latitude */
public final double latitude;
/** Longitude */
public final double longitude;

/**
 * Location with latitude and longitude
 * @param latitude location latitude
 * @param longitude location longitude
 */
public Location(double latitude, double longitude) {
	this.latitude = latitude;
	this.longitude = longitude;
}
}
