package com.example.example6_13scrolliew1v;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout1);

        for(int i = 0; i <100; i++){
            Button button = new Button(this);
            button.setText("btn"+i);
            button.setTextSize(30);
            linearLayout.addView(button);
        }
    }
}
