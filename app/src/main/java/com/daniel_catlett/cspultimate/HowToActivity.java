package com.daniel_catlett.cspultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HowToActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);
        getSupportActionBar().hide();
    }
}
