package com.example.example6_1textclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {

    Button GetTime;
    TextClock clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetTime = findViewById(R.id.getTime);
        clock = findViewById(R.id.clock1);
        clock.setVisibility(View.INVISIBLE);

        GetTime.setOnClickListener(v -> clock.setVisibility(View.VISIBLE));
    }
}
