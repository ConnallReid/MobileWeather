package com.coursework.connall.mobileweather;

import java.io.Serializable;

/**
 * Created by Connall on 07/12/2016.
 */

public class WeatherDBinfo implements Serializable {

// *********************************************
// Declare variables etc.
// *********************************************

    private String WeatherImg;
    private String WeatherDes;

    private static final long serialVersionUID = 0L;
// *********************************************
// Declare getters and setters etc.
// *********************************************

    public String getWeatherImg() {
        return WeatherImg;
    }

    public void setWeatherImg(String WeatherImg) {
        this.WeatherImg = WeatherImg;
    }

    public String getWeatherDes() {
        return WeatherDes;
    }

    public void setWeatherDes(String WeatherDes) {
        this.WeatherDes = WeatherDes;
    }


}