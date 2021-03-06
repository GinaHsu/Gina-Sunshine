/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.sunshine.data.WeatherContract.WeatherEntry;

/**
 * Manages a local database for weather data.
 */
// TODO (11) Extend SQLiteOpenHelper from WeatherDbHelper
public class WeatherDbHelper extends SQLiteOpenHelper{

//  TODO (12) Create a public static final String called DATABASE_NAME with value "weather.db"
     /* Database names should be descriptive and end with the .db extension. */
    public static final String DATABASE_NAME = "weather.db";

//  TODO (13) Create a private static final int called DATABASE_VERSION and set it to 1
    private static final int DATABASE_VERSION = 1;

//  TODO (14) Create a constructor that accepts a context and call through to the superclass constructor
    public WeatherDbHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


//  TODO (15) Override onCreate and create the weather table from within it

    /**
     * Called when the database is created for the first time.
     * This is where the creation of tables and the initial population of the tables should happen,
     *
     * @param db The database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
         *This String will contain a simple SQL statement that will create a table that will
         * cache our weather data.
         */
        final String SQL_CREATE_WEATHER_TABLE =

                "CREATE TABLE " + WeatherEntry.TABLE_NAME + "(" +

                /*
                 * WeatherEntry did not explicitly declare a column called "_ID".
                 * However, WeatherEntry implements the interface, "BaseColumns",
                 * which does have a field name "_ID". We use that here to designate
                 * our table's primary key.
                 */
                WeatherEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                WeatherEntry.COLUMN_DATE + " INTEGER, " +

                WeatherEntry.COLUMN_WEATHER_ID + " INTEGER, " +

                WeatherEntry.COLUMN_MIN_TEMP + " REAL, " +
                WeatherEntry.COLUMN_MAX_TEMP + " REAL, " +

                WeatherEntry.COLUMN_HUMIDITY + " REAL, " +
                WeatherEntry.COLUMN_PRESSURE + " REAL, " +

                WeatherEntry.COLUMN_WIND_SPEED + " REAL, " +
                WeatherEntry.COLUMN_DEGREES + " REAL" + ");";

        /*
         * After we have spelled out our SQLite table creation statement above, we actually execute
         * that SQL with the execSQL method of our SQLite database object.
         */
        db.execSQL(SQL_CREATE_WEATHER_TABLE);
    }

//  TODO (16) Override onUpgrade, but don't do anything within it yet

    /**
     * This database is only a cache for online data, so its upgrade policy is simply to discard
     * the data and call through to onCreate to recreate the table. Note that this only fires if
     * you change the version number for your database (in our case, DATABASE_VERSION).
     *
     * It does NOT depend on the version number for your application found in your app/build.gradle file.
     * If you want to updata the schema withour wiping data, commenting out the current body of
     * this method should be your top priority before modifying this method.
     *
     * @param db Database that is being upgraded
     * @param oldVersion The old database version
     * @param newVersion The new database version
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}