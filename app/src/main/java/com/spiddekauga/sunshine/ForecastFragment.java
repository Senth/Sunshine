package com.spiddekauga.sunshine;

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

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {
private static final Location LUND_LOCATION = new Location(55.7, 13.2);
ArrayAdapter<String> mForecastAdapter;

@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setHasOptionsMenu(true);
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
						 Bundle savedInstanceState) {
	View rootView = inflater.inflate(R.layout.forecast_list, container, false);

	List<String> weatherItems = new ArrayList<>();
	weatherItems.add("Loading...");

	FragmentActivity fragmentActivity = getActivity();
	int file = R.layout.list_item_forecast;
	int textViewId = R.id.list_item_forecast_textview;

	mForecastAdapter = new ArrayAdapter<>(fragmentActivity, file, textViewId, weatherItems);

	View view = rootView.findViewById(R.id.listView_forecast);
	if (view instanceof ListView) {
		ListView forecastView = (ListView) view;
		forecastView.setAdapter(mForecastAdapter);
	}

	refresh();

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
		refresh();
		return true;
	}

	return super.onOptionsItemSelected(item);
}

private void refresh() {
	FetchForecastTask fetchForecastTask = new FetchForecastTask(mForecastAdapter);
	fetchForecastTask.execute(LUND_LOCATION);
}
}
