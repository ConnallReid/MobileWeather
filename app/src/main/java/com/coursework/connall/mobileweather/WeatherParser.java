package com.coursework.connall.mobileweather;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

/**
 * Created by Connall on 05/12/2016.
 */

public class WeatherParser{
    public LinkedList<WeatherRssItem> ParseStart(String dataToParse){

    URL url1 = null;
    try {
        url1 = new URL(dataToParse);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    Log.e("Checks", "Website " + url1);
    LinkedList<WeatherRssItem> alist = null;
    alist=parseData(url1);
    return alist;
}

        private LinkedList<WeatherRssItem> parseData(URL dataToParse)
        {
            WeatherRssItem Info=null;
            LinkedList<WeatherRssItem> alist = null;

            try
            {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();
                //xpp.setInput( new StringReader ( dataToParse ) );
                xpp.setInput(getInputStream(dataToParse), "UTF_8");
                boolean stared=false;
                int eventType = xpp.getEventType();
                //boolean insideItem = false;
                alist  = new LinkedList<WeatherRssItem>();
                while (eventType != XmlPullParser.END_DOCUMENT)
                {
                    // Found a start tag
                    if(eventType == XmlPullParser.START_TAG)
                    {
                        // Check which Tag we have
                        if (xpp.getName().equalsIgnoreCase("item"))//channel
                        {
                            if(!stared){
                                stared=true;
                            }
                        }
                        else
                            // Check which Tag we have
                            if (xpp.getName().equalsIgnoreCase("title")&&stared)
                            {
                                Info = new WeatherRssItem();
                                String Temp= xpp.nextText();
                                Info.setTitle(Temp);
                            }
                            else if (xpp.getName().equalsIgnoreCase("description")&&stared)
                            {
                                String Temp= xpp.nextText();
                                Info.setDescription(Temp);
                            }
                            else if (xpp.getName().equalsIgnoreCase("point")&&stared)
                            {
                                String Temp= xpp.nextText();
                                Info.setGeo(Temp);
                            }

                    }else
                    if(eventType == XmlPullParser.END_TAG)
                    {
                        if (xpp.getName().equalsIgnoreCase("item"))
                        {
                            //Log.e("MyTag","widget is " + widget.toString());
                            alist.add(Info);
                        }
                        else
                        if (xpp.getName().equalsIgnoreCase("channel"))
                        {
                            int size;
                            size = alist.size();
                            //Log.e("MyTag", "channel size is " + size);
                        }
                    }

                    // Get the next event
                    eventType = xpp.next();

                } // End of while
            }
            catch (XmlPullParserException ae1)
            {
                Log.e("MyTag", "Parsing error " + ae1.toString());
            }
            catch (IOException ae1)
            {
                Log.e("MyTag", "IO error during parsing");
            }
            return alist;
        }
        public InputStream getInputStream(URL url) {
            try {
                return url.openConnection().getInputStream();
            } catch (IOException e) {
                return null;
            }
        }
}
