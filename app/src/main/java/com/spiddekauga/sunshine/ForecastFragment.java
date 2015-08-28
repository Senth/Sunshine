package com.spiddekauga.sunshine;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {

private ArrayAdapter<String> mForecastAdapter = null;

public ForecastFragment() {
}

@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setHasOptionsMenu(true);
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
						 Bundle savedInstanceState) {
	View rootView = inflater.inflate(R.layout.forecast_list, container, false);

	String[] weatherItems = {
			"Today — Sunny — 24/15°",
			"Tomorrow — Cloudy — 23/20°",
			"Saturday — Sunny — 30/28°",
			"Sunday — Rainy — 31/22°",
			"Monday — Sunny — 28/22°",
			"Tuesday — Sunny — 26/18°",
			"Wednesday — Rainy — 22/15°"
	};

	FragmentActivity fragmentActivity = getActivity();
	int file = R.layout.list_item_forecast;
	int textViewId = R.id.list_item_forecast_textview;

	mForecastAdapter = new ArrayAdapter<>(fragmentActivity, file, textViewId, weatherItems);

	View view = rootView.findViewById(R.id.listView_forecast);
	if (view instanceof ListView) {
		ListView forecastView = (ListView) view;
		forecastView.setAdapter(mForecastAdapter);
	}

	return rootView;
}

@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	inflater.inflate(R.menu.forecast_menu, menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	int id = item.getItemId();

	if (id == R.id.action_refresh) {
		FetchForecastTask fetchForecastTask = new FetchForecastTask();
		fetchForecastTask.execute();
		return true;
	}

	return super.onOptionsItemSelected(item);
}
}
