package com.spiddekauga.sunshine;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import com.spiddekauga.http.HttpGetBuilder;
import com.spiddekauga.http.HttpResponseParser;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Fetches weather data from the weather api
 * @author Matteus Magnusson <matteus.magnusson@spiddekauga.com>
 */
class FetchForecastTask extends AsyncTask<Location, Void, WeatherCollection> {
private static final String APPID = "dbba3fda691910e912ea9b2eec9151f2";
private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily";
private final ArrayAdapter<String> mForecastAdapter;

/**
 * Create a new fetch forecast task
 * @param forecastAdapter the adapter to update the information of
 */
FetchForecastTask(ArrayAdapter<String> forecastAdapter) {
	mForecastAdapter = forecastAdapter;
}

@Override
protected WeatherCollection doInBackground(Location... params) {
	HttpGetBuilder getBuilder = new HttpGetBuilder(BASE_URL);

	if (params.length != 1) {
		return null;
	}

	Location location = params[0];

	try {
		getBuilder.addParameter("units", "metric");
		getBuilder.addParameter("lat", location.latitude);
		getBuilder.addParameter("lon", location.longitude);
		getBuilder.addParameter("cnt", 7);
		getBuilder.addParameter("APPID", APPID);
		HttpURLConnection urlConnection = getBuilder.build();

		String jsonResponse = HttpResponseParser.getStringResponse(urlConnection);

		urlConnection.disconnect();

		return WeatherDataParser.toWeatherCollection(jsonResponse);
	} catch (IOException | JSONException e) {
		e.printStackTrace();
	}

	return null;
}

@Override
protected void onPostExecute(WeatherCollection result) {
	if (result != null) {
		mForecastAdapter.clear();
		mForecastAdapter.addAll(result.getAllInfos());
	}
}
}
