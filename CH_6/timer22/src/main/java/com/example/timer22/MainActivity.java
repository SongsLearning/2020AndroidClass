package com.example.timer22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer timer;
    Button startBtn, stopBtn, resetBtn;
    long timeNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = findViewById(R.id.timer);
        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);
        resetBtn = findViewById(R.id.resetBtn);

        Log.d("elapsedRealtime : ",String.valueOf(SystemClock.elapsedRealtime()));

        //region
        startBtn.setOnClickListener(view -> {
            timer.setBase(SystemClock.elapsedRealtime()+ timeNum);
            timer.start();
        });

        stopBtn.setOnClickListener(view -> {
            timeNum = timer.getBase() -SystemClock.elapsedRealtime();
            timer.stop();
        });

        resetBtn.setOnClickListener(view -> {
            timer.setBase(SystemClock.elapsedRealtime());
            timer.stop();
            timeNum = 0;
        });

        //endregion


        //3. 버튼     클릭 이벤트
        //TICK
        timer.setOnChronometerTickListener(view -> Log.d("realtime",String.valueOf(SystemClock.elapsedRealtime())));
    }

}
