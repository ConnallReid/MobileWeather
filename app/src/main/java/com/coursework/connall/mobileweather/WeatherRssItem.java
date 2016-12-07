package com.coursework.connall.mobileweather;

import android.util.Log;

/**
 * Created by Connall on 05/12/2016.
 */

public class WeatherRssItem {
    private String Title;
    private String Description;
    private String Geo;
    private String WeatherType;
    private String MaxTemp;
    private String MinTemp;
 public WeatherRssItem(){
     this.Title="";
     this.Description="";
     this.Geo="";
     this.WeatherType="";
     this.MaxTemp="";
     this.MinTemp="";
 }
    public String getTitle(){
        return Title;
    }
    public void setTitle(String Ntitle){
        this.Title=Ntitle;
    }
    public String getDescription(){
        return Description;
    }
    public void setDescription(String Ntitle){
        this.Description=Ntitle;
    }
    public String getGeo(){
        return Geo;
    }
    public void setGeo(String Ntitle){
        this.Geo=Ntitle;
    }
    public String getWeatherType(){
        String Type =Title;
        Type= Type.substring((Type.indexOf(":"))+2);
        Type=Type.substring(0,Type.indexOf(","));

        return Type;
    }
    public void setWeatherType(String Ntitle){
        this.WeatherType=Ntitle;
    }
    public String getMaxTemp(){
        String Type =Title;
        Type= Type.substring((Type.indexOf(":"))+2);
        Type=Type.substring(0,Type.indexOf(","));

        return Type;
    }
    public void setMaxTemp(String Ntitle){
        this.MaxTemp=Ntitle;
    }
    public String getMinTemp(){
        String Type =Title;
        Type= Type.substring((Type.indexOf(":"))+2);
        Type=Type.substring(0,Type.indexOf(","));

        return Type;
    }
    public void setMinTemp(String Ntitle){
        this.MinTemp=Ntitle;
    }
}
