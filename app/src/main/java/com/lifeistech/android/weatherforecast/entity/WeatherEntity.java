package com.lifeistech.android.weatherforecast.entity;

import java.util.Date;

/**
 * Created by rild on 16/02/16.
 */
public class WeatherEntity {
    private static final long serialVersionUID = 7468907373314597663L;

    public String place;
    public double temperature;
    public double humidity;
    public double windSpeed;
    public int pressure;
    public String iconUri;
    public String description;
    public Date day;
    public boolean isFetched;

    public WeatherEntity() {
        // Default values
        day = new Date();
        temperature = humidity = windSpeed = pressure = 0;
        isFetched = false;
    }
}
