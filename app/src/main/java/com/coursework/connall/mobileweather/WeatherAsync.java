package com.coursework.connall.mobileweather;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.util.LinkedList;

/**
 * Created by Connall on 05/12/2016.
 */
public class WeatherAsync extends AsyncTask<String,Integer,LinkedList<WeatherRssItem>>{
    private Context appContext;
    private String UrlParseAberdeen,UrlParseDundee,UrlParseEdinburgh,UrlParseFortWillaim,UrlParseGlasgow,UrlParseInverness,UrlParsePerth,UrlParseStirling,UrlParseThurso;

    public LinkedList<WeatherRssItem> alist=null;

    public WeatherAsync(Context CurrentAppContext,String RssUrlUrlParseAberdeen,String RssUrlUrlParseDundee,String RssUrlUrlParseEdinburgh,String RssUrlUrlParseFortWillaim,String RssUrlUrlParseGlasgow,String RssUrlUrlParseInverness,String RssUrlUrlParsePerth,String RssUrlUrlParseStirling,String RssUrlUrlParseThurso){

        appContext=CurrentAppContext;
        UrlParseAberdeen= RssUrlUrlParseAberdeen;
        UrlParseDundee=RssUrlUrlParseDundee;
        UrlParseEdinburgh=RssUrlUrlParseEdinburgh;
        UrlParseFortWillaim=RssUrlUrlParseFortWillaim;
        UrlParseGlasgow=RssUrlUrlParseGlasgow;
        UrlParseInverness=RssUrlUrlParseInverness;
        UrlParsePerth=RssUrlUrlParsePerth;
        UrlParseStirling=RssUrlUrlParseStirling;
        UrlParseThurso=RssUrlUrlParseThurso;
    }
    @Override
    protected void onPreExecute(){

    }
    @Override
    protected LinkedList<WeatherRssItem> doInBackground(String... params){
        //declare parcer
        WeatherParser rssParser= new WeatherParser();
        alist=rssParser.ParseStart(UrlParseAberdeen);
        //alist+=rssParser.ParseStart(UrlParseDundee);
        return alist;
    }
    @Override
    protected void onPostExecute(LinkedList<WeatherRssItem> result){

    }
}
