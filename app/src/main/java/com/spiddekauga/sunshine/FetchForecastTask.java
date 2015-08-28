package com.spiddekauga.sunshine;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.spiddekauga.http.HttpGetBuilder;
import com.spiddekauga.http.HttpResponseParser;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by senth on 2015-08-21.
 */
public class FetchForecastTask extends AsyncTask<Location, Void, String> {
private static final String LOG_TAG = FetchForecastTask.class.getSimpleName();

@Override
protected String doInBackground(Location... params) {
	HttpGetBuilder getBuilder = new HttpGetBuilder("http://api.openweathermap.org/data/2.5/daily");

	try {
		getBuilder.addParameter("units", "metric");
		getBuilder.addParameter("q", "Lund,se");
		getBuilder.addParameter("cnt", "7");
		HttpURLConnection urlConnection = getBuilder.build();

		HttpResponseParser responseParser = new HttpResponseParser();
		String jsonResponse = responseParser.getStringResponse(urlConnection);

		urlConnection.disconnect();

		return jsonResponse;
	} catch (IOException e) {
		e.printStackTrace();
	}

	return null;
}

@Override
protected void onPostExecute(String result) {
	Log.d(LOG_TAG, result);
}
}
