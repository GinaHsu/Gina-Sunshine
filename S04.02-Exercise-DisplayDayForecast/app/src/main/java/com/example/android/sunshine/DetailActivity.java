package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // TODO (2) Display the weather forecast that was passed from MainActivity
        TextView mDisplay = (TextView) findViewById(R.id.weatherDetail_display);

        Intent intentToStartDetailActivity = getIntent();

        if(intentToStartDetailActivity.hasExtra(Intent.EXTRA_TEXT)){
            String intentText = intentToStartDetailActivity.getStringExtra(Intent.EXTRA_TEXT);

            mDisplay.setText(intentText);
        }
    }
}