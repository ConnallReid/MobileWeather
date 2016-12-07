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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Connall on 05/12/2016.
 */


public class CityListActivity extends AppCompatActivity  {

    private ListView cities;

    LinkedList<WeatherRssItem> WeatherList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

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
        //Log.e("ParseInfo"," "+WeatherList.get(0).getWeatherType());

        cities = (ListView) findViewById(R.id.CityList);
        cities.setAdapter(new WeatherListAdapter(this,WeatherList));
/*
        List<String> cityList = new ArrayList<String>();

        cityList.add("Aberdeen");
        cityList.add("Dundee");
        cityList.add("Edinburgh");
        cityList.add("Fort Willaim");
        cityList.add("Glasgow");
        cityList.add("Inverness");
        cityList.add("Perth");
        cityList.add("Stirling");
        cityList.add("Thurso");

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cityList );

        cities.setAdapter(new WrapperListAdapter(this,WeatherList));
    }
    public void fillList(){
       */
    }
}