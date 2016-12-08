package com.coursework.connall.mobileweather;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import java.util.LinkedList;

/**
 * Created by Connall on 07/12/2016.
 */

public class FavoriteActivity extends AppCompatActivity {
    public LinkedList<WeatherRssItem> alist=new LinkedList<WeatherRssItem>();;
    private ListView city;
    WeatherDBinfo DbWeatherInfo;
    LinkedList<WeatherRssItem> WeatherList=null;

    FragmentManager fmAboutDialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_layout);

        android.support.v7.app.ActionBar ccActionBar = getSupportActionBar();
        if (ccActionBar != null)
        {
            ccActionBar.setDisplayShowHomeEnabled(true);
            //ccActionBar.setLogo(R.drawable.cloudy);
            ccActionBar.setDisplayUseLogoEnabled(true);
        }
        fmAboutDialogue = this.getFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.aberdeen:
                ((TextView)findViewById(R.id.FavoriteLocation)).setText("Aberdeen");
                return true;

            case R.id.dundee:
                ((TextView)findViewById(R.id.FavoriteLocation)).setText("Dundee");
                return true;

            case R.id.edinburgh:
                ((TextView)findViewById(R.id.FavoriteLocation)).setText("Edinburgh");
                return true;

            case R.id.fortwillaim:
                ((TextView)findViewById(R.id.FavoriteLocation)).setText("Fort Willaim");
                return true;

            case R.id.glasgow:
                ((TextView)findViewById(R.id.FavoriteLocation)).setText("Glasgow");
                return true;

            case R.id.inverness:
                ((TextView)findViewById(R.id.FavoriteLocation)).setText("Inverness");
                return true;

            case R.id.perth:
                ((TextView)findViewById(R.id.FavoriteLocation)).setText("Perth");
                return true;

            case R.id.stirling:
                ((TextView)findViewById(R.id.FavoriteLocation)).setText("Stirling");
                return true;

            case R.id.thurso:
                ((TextView)findViewById(R.id.FavoriteLocation)).setText("Thurso");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
