package com.olugbadeshina.travelmantics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startFire(View view) {
        Intent intent = new Intent(this, ListActiviy.class);
        startActivity(intent);
        juiiihh
    }
}
