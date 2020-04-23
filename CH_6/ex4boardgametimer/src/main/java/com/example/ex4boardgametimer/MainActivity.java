package com.example.ex4boardgametimer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.OverlappingFileLockException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editTextEnteredSecond;
    Button btnTimerSwitch, btnReset, btnPauseRestart;
    TextView textViewCopyright;
    CountDownTimer countDownTimer;

    TextToSpeech textToSpeech;

    long fullTime, halfTime;
    boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        {
            editTextEnteredSecond = findViewById(R.id.editTextEnteredSeconds);
            btnTimerSwitch = findViewById(R.id.btnTimerSwitch);
            btnReset = findViewById(R.id.btnReset);
            btnPauseRestart = findViewById(R.id.btnPauseRestart);
            textViewCopyright = findViewById(R.id.textViewCopyright);
            textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
                if(status == TextToSpeech.SUCCESS)
                    textToSpeech.setLanguage(Locale.ENGLISH);

            });
        }

        btnTimerSwitch.setOnClickListener(v -> {
            MediaPlayer.create(getApplicationContext(), R.raw.bell_sound2).start();

            cencleTimer();
            resetTimer();
            countDownTimer = countDownTimer(fullTime);

            countDownTimer.start();
        });

        btnReset.setOnLongClickListener(view -> {
            if(editTextEnteredSecond.hasFocus()){
                editTextEnteredSecond.clearFocus();
                InputMethodManager imm = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextEnteredSecond.getWindowToken(), 0);
            }

            resetTimer(); //타이머 초기화
            cencleTimer(); //타이머 멈추기

            String msg = String.format("Reset to %d seconds", fullTime);
            textToSpeech.speak("",TextToSpeech.QUEUE_FLUSH, null);

            btnTimerSwitch.setEnabled(true);
            return true;
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
                changeTestSize(currentTime);

                if(currentTime == halfTime)
                {
                    MediaPlayer.create(getApplicationContext(), R.raw.warning_sound);
                }
                if(currentTime <= 10)
                {
                    btnTimerSwitch.setTextColor(Color.RED);
                    textToSpeech.speak(String.valueOf(currentTime),TextToSpeech.QUEUE_FLUSH,null);
                }
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
        if(editTextEnteredSecond.getText().equals("")){
            Toast.makeText(this,"null",Toast.LENGTH_SHORT).show();
            return;
        }

        fullTime = Long.parseLong(editTextEnteredSecond.getText().toString());
        halfTime = Math.round(fullTime/2);


        changeTestSize(fullTime);

        btnTimerSwitch.setBackgroundColor(Color.YELLOW);
        btnTimerSwitch.setTextColor(Color.BLACK);
        btnTimerSwitch.setText(String.valueOf(fullTime));


    }

    private void changeTestSize(long seconds)
    {
        if(seconds >= 100){
            btnTimerSwitch.setTextSize(200);
        }
        else if(seconds >= 10)
        {
            btnTimerSwitch.setTextSize(300);
        }
        else {
            btnTimerSwitch.setTextSize(400);
        }
    }


}
