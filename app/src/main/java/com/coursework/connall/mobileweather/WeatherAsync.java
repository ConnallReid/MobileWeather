package com.coursework.connall.mobileweather;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.util.LinkedList;

/**
 * Created by Connall on 05/12/2016.
 */
public class WeatherAsync extends AsyncTask<String,Integer,LinkedList<WeatherRssItem>>{
    private Context appContext;
    private String UrlParseAberdeen,UrlParseDundee,UrlParseEdinburgh,UrlParseFortWillaim,UrlParseGlasgow,UrlParseInverness,UrlParsePerth,UrlParseStirling,UrlParseThurso;

    public LinkedList<WeatherRssItem> alist=new LinkedList<WeatherRssItem>();
    public LinkedList<WeatherRssItem> returnlist=null;

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
        returnlist=rssParser.ParseStart(UrlParseAberdeen);
        WeatherRssItem  Info =null;
        for(int i=0;i<3;i++){
            Info = new WeatherRssItem();
            Info.setCityName("Aberdeen");
            Info.setTitle(returnlist.get(i).getTitle());
            Info.setDescription(returnlist.get(i).getDescription());
            alist.add(Info);
        }
        returnlist=rssParser.ParseStart(UrlParseDundee);
        for(int i=0;i<3;i++){
            Info = new WeatherRssItem();
            Info.setCityName("Dundee");
            Info.setTitle(returnlist.get(i).getTitle());
            Info.setDescription(returnlist.get(i).getDescription());
            alist.add(Info);
        }
        returnlist=rssParser.ParseStart(UrlParseEdinburgh);
        for(int i=0;i<3;i++){
            Info = new WeatherRssItem();
            Info.setCityName("Edinburgh");
            Info.setTitle(returnlist.get(i).getTitle());
            Info.setDescription(returnlist.get(i).getDescription());
            alist.add(Info);
        }
        returnlist=rssParser.ParseStart(UrlParseFortWillaim);
        for(int i=0;i<3;i++){
            Info = new WeatherRssItem();
            Info.setCityName("Fort Willaim");
            Info.setTitle(returnlist.get(i).getTitle());
            Info.setDescription(returnlist.get(i).getDescription());
            alist.add(Info);
        }
        returnlist=rssParser.ParseStart(UrlParseGlasgow);
        for(int i=0;i<3;i++){
            Info = new WeatherRssItem();
            Info.setCityName("Glasgow");
            Info.setTitle(returnlist.get(i).getTitle());
            Info.setDescription(returnlist.get(i).getDescription());
            alist.add(Info);
        }
        returnlist=rssParser.ParseStart(UrlParseInverness);
        for(int i=0;i<3;i++){
            Info = new WeatherRssItem();
            Info.setCityName("Inverness");
            Info.setTitle(returnlist.get(i).getTitle());
            Info.setDescription(returnlist.get(i).getDescription());
            alist.add(Info);
        }
        returnlist=rssParser.ParseStart(UrlParsePerth);
        for(int i=0;i<3;i++){
            Info = new WeatherRssItem();
            Info.setCityName("Perth");
            Info.setTitle(returnlist.get(i).getTitle());
            Info.setDescription(returnlist.get(i).getDescription());
            alist.add(Info);
        }
        returnlist=rssParser.ParseStart(UrlParseStirling);
        for(int i=0;i<3;i++){
            Info = new WeatherRssItem();
            Info.setCityName("Stirling");
            Info.setTitle(returnlist.get(i).getTitle());
            Info.setDescription(returnlist.get(i).getDescription());
            alist.add(Info);
        }
        returnlist=rssParser.ParseStart(UrlParseThurso);
        for(int i=0;i<3;i++){
            Info = new WeatherRssItem();
            Info.setCityName("Thurso");
            Info.setTitle(returnlist.get(i).getTitle());
            Info.setDescription(returnlist.get(i).getDescription());
            alist.add(Info);
        }
        //Log.e("Hello",""+alist.get(10).getTitle());
        return alist;
    }
    @Override
    protected void onPostExecute(LinkedList<WeatherRssItem> result){

    }

    public void Addtolist(LinkedList<WeatherRssItem> mainlist,LinkedList<WeatherRssItem> Addlist){
        for(int i=0;i<3;i++){
            WeatherRssItem  Info = new WeatherRssItem();
            Info.setTitle(Addlist.get(i).getTitle());
            Info.setDescription(Addlist.get(i).getDescription());
            alist.add(Info);
        }
        Log.e("magic",""+alist.get(1).getTitle());
    }
}
