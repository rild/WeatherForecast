package com.lifeistech.android.weatherforecast.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

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

    @Expose
    @SerializedName("pinpointLocations")
    private List<PinpointLocations> pinpointLocations;

    @Expose
    @SerializedName("forecasts")
    private List<Forecast> forecasts;

    @Expose
    @SerializedName("link")
    private String link;

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<PinpointLocations> getPinpointLocations() {
        return pinpointLocations;
    }

    public void setPinpointLocations(List<PinpointLocations> pinpointLocations) {
        this.pinpointLocations = pinpointLocations;
    }
}
