package com.lifeistech.android.weatherforecast;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.cookpad.android.rxt4a.schedulers.AndroidSchedulers;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.lifeistech.android.weatherforecast.controller.service.WeatherApi;
import com.lifeistech.android.weatherforecast.entity.WeatherEntity;

import java.util.Date;

import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.converter.GsonConverter;
import rx.Observer;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {
	private static final String END_POINT = "http://weather.livedoor.com";
	private static final String TAG = MainActivity.class.getSimpleName();

	private Tab tab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	    // Create the actionbar
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
 
        // Create first Tab
        tab = actionBar.newTab().setTabListener(new HomeTab());
        tab.setText(getResources().getString(R.string.tab_today));
        actionBar.addTab(tab);
 
        // Create Second Tab
        tab = actionBar.newTab().setTabListener(new WeekTab());
        // Set Tab Title
        tab.setText(getResources().getString(R.string.tab_week));
        actionBar.addTab(tab);
	}
	
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	public boolean isOnline() {
	    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }	
	
	    return false;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void retrofitConnect() {
		Gson gson = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.registerTypeAdapter(Date.class, new DateTypeAdapter())
				.create();


		// RestAdapterを作成する
		RestAdapter adapter = new RestAdapter.Builder()
				.setEndpoint(END_POINT)
				.setConverter(new GsonConverter(gson))
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.setLog(new AndroidLog("=NETWORK="))
				.build();

		// 天気予報情報を取得する
		//http://weather.livedoor.com/area/forecast/200010
		WeatherApi api =  adapter.create(WeatherApi.class);

		Observer observer = new Observer<WeatherEntity>() {
			@Override
			public void onCompleted() {
				Log.d(TAG, "onCompleted()");
				//必要な情報を取り出して画面に表示してください。
			}

			@Override
			public void onError(Throwable e) {
				Log.e(TAG, "Error : " + e.toString());
			}

			@Override
			public void onNext(WeatherEntity weather) {
				Log.d(TAG, "onNext()");
				((TextView)findViewById(R.id.text)).setText(weather.getPinpointLocations().get(0).getName());
			}
		};

		api.getWeather("200010")
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(observer);
	}

}