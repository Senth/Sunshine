package com.spiddekauga.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

private ArrayAdapter<String> mForecastAdapter = null;

public MainActivityFragment() {
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
}
