package com.example.ex4boardgametimer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.channels.OverlappingFileLockException;

public class MainActivity extends AppCompatActivity {

    EditText editTextEnteredSecond;
    Button btnTimerSwitch, btnReset, btnPauseRestart;
    TextView textViewCopyright;
    CountDownTimer countDownTimer;

    long fullTime, halfTime;
    boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextEnteredSecond = findViewById(R.id.editTextEnteredSeconds);
        btnTimerSwitch = findViewById(R.id.btnTimerSwitch);
        btnReset = findViewById(R.id.btnReset);
        btnPauseRestart = findViewById(R.id.btnPauseRestart);
        textViewCopyright = findViewById(R.id.textViewCopyright);


        btnTimerSwitch.setOnClickListener(v -> {
            MediaPlayer.create(getApplicationContext(), R.raw.bell_sound2).start();

            cencleTimer();
            resetTimer();
            countDownTimer = countDownTimer(fullTime);

            countDownTimer.start();
        });

        btnReset.setOnLongClickListener(view -> {
            resetTimer(); //타이머 초기화
            cencleTimer(); //타이머 멈추기

            btnPauseRestart.setEnabled(true);
            return false;
        });

        btnPauseRestart.setOnClickListener(v -> {
            if(isPaused){
                btnPauseRestart.setText(R.string.pause);

                countDownTimer = countDownTimer(Long.parseLong(btnTimerSwitch.getText().toString()));
                countDownTimer.start();
                isPaused = false;
            }
            else {
                countDownTimer.cancel();  //timer stop
                btnPauseRestart.setText(R.string.restart);
                isPaused = true;


            }
        });
    }

    private void cencleTimer(){
        if(countDownTimer != null)
            countDownTimer.cancel();
    }

    private CountDownTimer countDownTimer(long t)
    {

        return new CountDownTimer(t*1000+1000,1000) {
            @Override
            public void onTick(long l) {
                long currentTime = l/1000;
                btnTimerSwitch.setText(String.valueOf(currentTime));
            }

            @Override
            public void onFinish() {
                btnTimerSwitch.setBackgroundColor(Color.DKGRAY);
                btnTimerSwitch.setTextColor(Color.GRAY);
                MediaPlayer.create(getApplicationContext(), R.raw.gameover_sound).start();
                btnTimerSwitch.setEnabled(false); //버튼 비활성화
            }
        };

    }


    private void resetTimer(){
        fullTime = Long.parseLong(editTextEnteredSecond.getText().toString());
        halfTime = Math.round(fullTime/2);

        btnTimerSwitch.setBackgroundColor(Color.YELLOW);
        btnTimerSwitch.setTextColor(Color.BLACK);
        btnTimerSwitch.setText(String.valueOf(fullTime));
    }
}
