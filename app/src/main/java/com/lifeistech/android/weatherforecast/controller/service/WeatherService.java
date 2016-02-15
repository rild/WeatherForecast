package com.lifeistech.android.weatherforecast.controller.service;

import com.lifeistech.android.weatherforecast.entity.WeatherEntity;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by rild on 16/02/16.
 */
public interface WeatherService {
    @GET("/data/2.5/{name}")
    public Observable<WeatherEntity> getWeather(@Path("name") String name, @Query("q") String q);
}
