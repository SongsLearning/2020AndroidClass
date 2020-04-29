package com.example.ex6_4timepickerdatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    RadioButton Cal, Time;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView Year, Month, Day, Hour, Minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono = findViewById(R.id.chronometer1);

        Cal = findViewById(R.id.Calset);
        Time = findViewById(R.id.Timeset);

        dPicker = findViewById(R.id.datePicker1);
        tPicker = findViewById(R.id.timePicker1);

        Year = findViewById(R.id.tvYear);
        Month = findViewById(R.id.tvMonth);
        Day = findViewById(R.id.tvDay);
        Hour = findViewById(R.id.tvHour);
        Minute = findViewById(R.id.tvMinute);

        Cal.setVisibility(View.INVISIBLE);
        Time.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);


        chrono.setOnClickListener(v -> {
            chrono.setBase(SystemClock.elapsedRealtime());
            chrono.start();
            Cal.setVisibility(View.VISIBLE);
            Time.setVisibility(View.VISIBLE);

        });

        chrono.setOnLongClickListener(v -> {
            chrono.stop();
            Cal.setVisibility(View.INVISIBLE);
            Time.setVisibility(View.INVISIBLE);
            dPicker.setVisibility(View.INVISIBLE);
            tPicker.setVisibility(View.INVISIBLE);

            Year.setText(Integer.toString(dPicker.getYear()));
            Month.setText(Integer.toString(1+dPicker.getMonth()));
            Day.setText(Integer.toString(dPicker.getDayOfMonth()));
            Hour.setText(Integer.toString(tPicker.getCurrentHour()));
            Minute.setText(Integer.toString(tPicker.getCurrentMinute()));
            return false;
        });


        Cal.setOnClickListener(v -> {
            tPicker.setVisibility(View.INVISIBLE);
            dPicker.setVisibility(View.VISIBLE);
        });

        Time.setOnClickListener(v -> {
            tPicker.setVisibility(View.VISIBLE);
            dPicker.setVisibility(View.INVISIBLE);
        });


    }
}
