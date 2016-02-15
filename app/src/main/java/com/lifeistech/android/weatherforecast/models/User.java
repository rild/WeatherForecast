package com.lifeistech.android.weatherforecast.models;

import android.location.Location;

public class User {
    public Location location;
    public Weather dayWeather;

    private User() {
    }

    private static User INSTANCE = new User();

    public static User getInstance() {
        return INSTANCE;
    }
}
