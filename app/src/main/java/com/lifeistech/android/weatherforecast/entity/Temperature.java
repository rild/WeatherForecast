package com.lifeistech.android.weatherforecast.entity;


/**
 * Created by rild on 16/02/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Temperature {

    @SerializedName("min")
    @Expose
    private Object min;
    @SerializedName("max")
    @Expose
    private Object max;

    /**
     * @return The min
     */
    public Object getMin() {
        return min;
    }

    /**
     * @param min The min
     */
    public void setMin(Object min) {
        this.min = min;
    }

    /**
     * @return The max
     */
    public Object getMax() {
        return max;
    }

    /**
     * @param max The max
     */
    public void setMax(Object max) {
        this.max = max;
    }

}
