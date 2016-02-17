package com.lifeistech.android.weatherforecast.entity;

/**
 * Created by rild on 16/02/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Description {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("publicTime")
    @Expose
    private String publicTime;

    /**
     *
     * @return
     * The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     * The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     * The publicTime
     */
    public String getPublicTime() {
        return publicTime;
    }

    /**
     *
     * @param publicTime
     * The publicTime
     */
    public void setPublicTime(String publicTime) {
        this.publicTime = publicTime;
    }

}