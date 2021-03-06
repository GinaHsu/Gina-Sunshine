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
package com.example.android.sunshine.sync;






import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

//  TODO (1) Create a class called SunshineSyncTask
//  TODO (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
public class SunshineSyncTask {
    /**
     * Performs the network request for updated weather, parses the JSON from that request, and
     * inserts the new weather information into our ContentProvider. Will notify the user that new
     * weather has been loaded if the user hasn't been notified of the weather within the last day
     * AND they haven't disabled notifications in the preferences screen.
     *
     * @param context Used to access utility methods and the ContentResolver
     */

    synchronized public static void syncWeather(Context context){

        //      TODO (3) Within syncWeather, fetch new weather data
        try{
            /*
             * getUrl: will return the URL that we need to get the forecast JSON for the weather.
             * It will decide whether to create a URL based off of the latitude and longitude or
             * off of a simple location as a String
             */
            URL weatherRequestUrl = NetworkUtils.getUrl(context);

            //Use the URL to retrieve the JSON
            String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

            //Parse the JSON into a list of weather values
            ContentValues[] weatherValues = OpenWeatherJsonUtils
                    .getWeatherContentValuesFromJson(context, jsonWeatherResponse);

            //      TODO (4) If we have valid results, delete the old data and insert the new
            /*
             * if JSON contains an error code, getWeatherContentValuesFromJson will return null.
             * Check for those cases to prevent any NullPointerExceptions being thrown.
             */
            if(weatherValues != null && weatherValues.length != 0){
                //get a ContentResolver to delete or insert data
                ContentResolver sunshineContentResolver = context.getContentResolver();

                //delete old weather data because we don't need to keep multiple days' data
                sunshineContentResolver.delete(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        null,
                        null);

                //Insert our new weather data into Sunshine's ContentProvider
                sunshineContentResolver.bulkInsert(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        weatherValues);

            }
            //If the code reaches this point, we have successfully performed our sync

        }catch(Exception e){
            // Sever probably invalid
            e.printStackTrace();
        }
    }

}