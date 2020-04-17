package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnStart, btnStop, btnPause;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.count);
        btnStart = findViewById(R.id.start);
        btnStop = findViewById(R.id.stop);
        btnPause = findViewById(R.id.puase);

        countDownTimer(30 * 1000, 1000);

        btnStart.setOnClickListener(v -> {
            countDownTimer.start();
        });

        btnStop.setOnClickListener(v -> {
            countDownTimer.cancel();
        });

        btnPause.setOnClickListener(v ->{
            if(btnPause.getText().equals("PUASE")){
                btnPause.setText("");
            }
            else
                btnPause.setText("");
        });
    }

    private void countDownTimer(long time, long interval){
        countDownTimer = new CountDownTimer(time, interval) {
            @Override
            public void onTick(long time) {
                textView.setText(String.valueOf(time/1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"CountDown Finished", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
