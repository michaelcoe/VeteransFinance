package com.example.interam.veteransfinance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Interam on 12/19/2014.
 */
public class SecondScreen extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_screen_layout);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
    }
}
