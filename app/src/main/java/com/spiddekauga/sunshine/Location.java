package com.spiddekauga.sunshine;

/**
 * Langitude and Longitude location for API calls
 * Created by senth on 2015-11-27.
 */
public class Location {
/**
 * Default constructor
 */
public Location() {
	this(0,0);
}

/**
 * Location with latitude and longitude
 * @param latitude location latitude
 * @param longitude location longitude
 */
public Location(double latitude, double longitude) {
	this.latitude = latitude;
	this.longitude = longitude;
}

/** Latitude */
public double latitude;
/** Longitude */
public double longitude;
}
