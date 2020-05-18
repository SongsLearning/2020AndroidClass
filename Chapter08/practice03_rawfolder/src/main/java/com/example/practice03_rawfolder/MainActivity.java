package com.example.practice03_rawfolder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Button btnISR, btnBR;

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnISR = findViewById(R.id.btnISR);
        btnBR = findViewById(R.id.btnBR);

        textView = findViewById(R.id.textView);

        btnISR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try(InputStreamReader isr = new InputStreamReader(getResources().openRawResource(R.raw.fc))) {

                    int i;
                    StringBuilder sb = new StringBuilder();

                    while ((i=isr.read())!= -1)
                    {
                        sb.append((char)i);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

     
    }


}
