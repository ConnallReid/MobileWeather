package com.coursework.connall.mobileweather;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Connall on 05/12/2016.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add mapp markers
        LatLng aberdeen = new LatLng(57.149621, -2.094313);
        LatLng dundee = new LatLng(56.462014, -2.970800);
        LatLng edinburgh = new LatLng(55.953390, -3.188334);
        LatLng fortWillaim = new LatLng(56.819809, -5.105252);
        LatLng glasgow = new LatLng(55.863004, -4.251360);
        LatLng inverness = new LatLng(57.477744, -4.224691);
        LatLng perth = new LatLng(56.395174, -3.430809);
        LatLng stirling = new LatLng(56.116550, -3.936858);
        LatLng thurso = new LatLng(58.593500, -3.522072);


        mMap.addMarker(new MarkerOptions().position(aberdeen).title("Aberdeen"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyintervals));

        mMap.addMarker(new MarkerOptions().position(dundee).title("Dundee"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyintervals));

        mMap.addMarker(new MarkerOptions().position(edinburgh).title("Edinburgh"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyintervals));

        mMap.addMarker(new MarkerOptions().position(fortWillaim).title("Fort Willaim"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.cloudy));

        mMap.addMarker(new MarkerOptions().position(glasgow).title("Glasgow"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyintervals));

        mMap.addMarker(new MarkerOptions().position(inverness).title("Inverness"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyintervals));

        mMap.addMarker(new MarkerOptions().position(perth).title("Perth"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyintervals));

        mMap.addMarker(new MarkerOptions().position(stirling).title("Stirling"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyintervals));

        mMap.addMarker(new MarkerOptions().position(thurso).title("Thurso"))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.sunnyintervals));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(57, -4.6),6.5f));
    }
}
