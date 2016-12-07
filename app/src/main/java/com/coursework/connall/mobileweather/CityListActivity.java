package com.coursework.connall.mobileweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.WrapperListAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Connall on 05/12/2016.
 */


public class CityListActivity extends AppCompatActivity  {
    public LinkedList<WeatherRssItem> alist=new LinkedList<WeatherRssItem>();;
    private ListView cities;
    WeatherDBinfo DbWeatherInfo;
    LinkedList<WeatherRssItem> WeatherList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        DbWeatherInfo=new WeatherDBinfo();
        String UrlAberdeen="http://open.live.bbc.co.uk/weather/feeds/en/2657832/3dayforecast.rss";
        String UrlDundee="http://open.live.bbc.co.uk/weather/feeds/en/2650752/3dayforecast.rss";
        String UrlEdinburgh="http://open.live.bbc.co.uk/weather/feeds/en/2650225/3dayforecast.rss";
        String UrlFortWillaim="http://open.live.bbc.co.uk/weather/feeds/en/2649169/3dayforecast.rss";
        String UrlGlasgow="http://open.live.bbc.co.uk/weather/feeds/en/2648579/3dayforecast.rss";
        String UrlInverness="http://open.live.bbc.co.uk/weather/feeds/en/2646088/3dayforecast.rss";
        String UrlPerth="http://open.live.bbc.co.uk/weather/feeds/en/2640358/3dayforecast.rss";
        String UrlStirling="http://open.live.bbc.co.uk/weather/feeds/en/2636910/3dayforecast.rss";
        String UrlThurso="http://open.live.bbc.co.uk/weather/feeds/en/2636910/3dayforecast.rss";

        WeatherAsync rssAsyncParse=new WeatherAsync(this,UrlAberdeen,UrlDundee,UrlEdinburgh,UrlFortWillaim,UrlGlasgow,UrlInverness,UrlPerth,UrlStirling,UrlThurso);
        try {
            WeatherList=rssAsyncParse.execute("").get();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        WeatherDB DBWeather =new WeatherDB(this,"WeatherConditions.db",null,1);
        try{
            DBWeather.dbCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //List<Integer> myImages = Arrays.asList(R.drawable.clearnight, R.drawable.cloudy, R.drawable.fog, R.drawable.hail, R.drawable.rain, R.drawable.sleet, R.drawable.snow, R.drawable.sunny, R.drawable.sunnyintervals, R.drawable.thunderstorm);

        for(int i=0;i<WeatherList.size();i++) {
            if((i==0)||(i==3)||(i==6)||(i==9)||(i==12)||(i==15)||(i==18)||(i==21)||(i==24)){
            WeatherRssItem Info = new WeatherRssItem();
                Info.setCityName(WeatherList.get(i).getCityName());
            Info.setTitle(WeatherList.get(i).getTitle());
            Info.setDescription(WeatherList.get(i).getDescription());
            alist.add(Info);}
        }
        Log.e("Testing",WeatherList.get(3).getWeatherType());
        DbWeatherInfo=DBWeather.FindWeatherIcon(WeatherList.get(1).getWeatherType());

        Log.e("WEatherdb",""+DbWeatherInfo.getWeatherImg());
        //Log.e("ParseInfo"," "+WeatherList.get(0).getWeatherType());

        cities = (ListView) findViewById(R.id.CityList);
        cities.setAdapter(new WeatherListAdapter(this,alist));

    }
}