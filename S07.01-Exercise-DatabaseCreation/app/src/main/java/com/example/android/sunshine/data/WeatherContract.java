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

import android.provider.BaseColumns;

/**
 * Defines table and column names for the weather database. This class is not necessary, but keeps
 * the code organized.
 */
public class WeatherContract {

//  TODO (1) Within WeatherContract, create a public static final class called WeatherEntry that implements BaseColumns
    /* Inner class that defines the table contents of the weather table */
    public static final class WeatherEntry implements BaseColumns {

    //  TODO (2) Create a public static final String call TABLE_NAME with the value "weather"
        /* Used internally as the name of our weather table. */
        public static final String TABLE_NAME = "weather";

    //   TODO (3) Create a public static final String call COLUMN_DATE with the value "date"
        /*
         * The date column will store the UTC date that correlates to the local date for which
         * each particular weather row represents.
         */
        public static final String COLUMN_DATE = "date";

    //  TODO (4) Create a public static final String call COLUMN_WEATHER_ID with the value "weather_id"
        /* Weather ID as returned by API, used to identify the icon to be used */
        public static final String COLUMN_WEATHER_ID = "weather_id";

    //  TODO (5) Create a public static final String call COLUMN_MIN_TEMP with the value "min"
    //  TODO (6) Create a public static final String call COLUMN_MAX_TEMP with the value "max"
        /* Min and max temperatures in °C for the day (stored as floats in the database) */
        public static final String COLUMN_MIN_TEMP = "min";
        public static final String COLUMN_MAX_TEMP = "max";

    //  TODO (7) Create a public static final String call COLUMN_HUMIDITY with the value "humidity"
        /* Humidity is stored as a float representing percentage */
        public static final String COLUMN_HUMIDITY = "humidity";

    //  TODO (8) Create a public static final String call COLUMN_PRESSURE with the value "pressure"
        /* Pressure is stored as a float representing percentage */
        public static final String COLUMN_PRESSURE = "pressure";

    //  TODO (9) Create a public static final String call COLUMN_WIND_SPEED with the value "wind"
        /* Wind speed is stored as a float representing wind speed in mph */
        public static final String COLUMN_WIND_SPEED = "wind";

    //  TODO (10) Create a public static final String call COLUMN_DEGREES with the value "degrees"
       /*
         * Degrees are meteorological degrees (e.g, 0 is north, 180 is south).
         * Stored as floats in the database.
         *
         * Note: These degrees are not to be confused with temperature degrees of the weather.
         */
       public static final String COLUMN_DEGREES = "degrees";

    }
}