package com.coursework.connall.mobileweather;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Connall on 07/12/2016.
 */
public class WeatherDB extends SQLiteOpenHelper {

        private static final int DB_VER = 1;
        private static final String DB_PATH = "/data/data/com.coursework.connall.mobileweather/databases/";
        private static final String DB_NAME = "WeatherConditions.db";
        private static final String TBL_WEATHERDATA = "Weather";

        public static final String COL_INDEX = "Index";
        public static final String COL__WEATHERCON = "WeatherCond";
        public static final String COL__WEATHERSIGN = "WeatherConditionSign";


        private final Context appContext;

        public WeatherDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            this.appContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String CREATE_WEATHERDATA_TABLE = "CREATE TABLE IF NOT EXISTS " +
                    TBL_WEATHERDATA + "("+COL_INDEX+ "INTEGER PRIMARY KEY,"
                    + COL__WEATHERCON + " TEXT," + COL__WEATHERSIGN + " TEXT" + ")";
            sqLiteDatabase.execSQL(CREATE_WEATHERDATA_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            if(newVersion > oldVersion)
            {
                sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_WEATHERDATA);
                onCreate(sqLiteDatabase);
            }
        }

        public void dbCreate() throws IOException {

            boolean dbExist = dbCheck();

            if(!dbExist){
                this.getReadableDatabase();

                try {
                    copyDBFromAssets();
                } catch (IOException e) {

                    throw new Error("Error copying database");
                }
            }
        }

        private boolean dbCheck(){

            File dbFile = appContext.getDatabasePath(DB_NAME);
            return dbFile.exists();
        }

        private void copyDBFromAssets() throws IOException{

            InputStream dbInput = null;
            OutputStream dbOutput = null;
            String dbFileName = DB_PATH + DB_NAME;

            try {

                dbInput = appContext.getAssets().open(DB_NAME);
                dbOutput = new FileOutputStream(dbFileName);
                //transfer bytes from the dbInput to the dbOutput
                byte[] buffer = new byte[1024];
                int length;
                while ((length = dbInput.read(buffer)) > 0) {
                    dbOutput.write(buffer, 0, length);
                }

                //Close the streams
                dbOutput.flush();
                dbOutput.close();
                dbInput.close();

            } catch (IOException e)
            {
                throw new Error("Problems copying DB!");
            }
        }

        public WeatherDBinfo FindWeatherIcon(String IconName) {

            String query = "Select * FROM " + TBL_WEATHERDATA + " WHERE " + COL__WEATHERCON + " =  \"" + IconName + "\"";

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery(query, null);

            WeatherDBinfo WeatherInfo = new WeatherDBinfo();
            Log.e("weatherDB"," "+cursor.moveToFirst());
            if (cursor.moveToFirst()) {
                cursor.moveToFirst();

                WeatherInfo.setWeatherDes(cursor.getString(1));
                WeatherInfo.setWeatherImg(cursor.getString(2));

                cursor.close();
            } else {
                WeatherInfo = null;
            }
            db.close();
            return WeatherInfo;
        }
    }

