package com.coursework.connall.mobileweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Connall on 07/12/2016.
 */

public class WeatherListAdapter extends BaseAdapter {

    private List<WeatherRssItem> items;
    private Context context;
    private LayoutInflater inflater;
    public WeatherListAdapter(Context context, List<WeatherRssItem> items) {
        inflater = LayoutInflater.from(context);
        this.items = items;
    }
    //  @Override
    public int getCount() {
        return items.size();
    }
    //  @Override
    public Object getItem(int position) {
        return items.get(position);
    }
    //@Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder {
        TextView textView1;
        TextView textView2;
        LinearLayout lLayout;
        ListView Lview;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        WeatherListAdapter.ViewHolder holder = null;
        // RelativeLayout ;
        if (convertView == null) {
            holder = new WeatherListAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.list_weather_layout, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.weather_name);
            holder.textView2 = (TextView) convertView.findViewById(R.id.weather_temp);
            holder.Lview =(ListView) convertView.findViewById(R.id.CityList);
            holder.lLayout = (LinearLayout) convertView.findViewById(R.id.weather_layout);
            convertView.setTag(holder);
        } else {
            holder = (WeatherListAdapter.ViewHolder) convertView.getTag();
        }

        holder.textView1.setText(items.get(position).getCityName());
        holder.textView1.setTextSize(36.0f);

        holder.textView2.setText(items.get(position).getTitle());
        holder.textView2.setTextSize(15.0f);

        return convertView;
    }
}

