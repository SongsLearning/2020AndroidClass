package com.example.ch7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button button;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.layoutinflater);
        linearLayout =findViewById(R.id.mainLiner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater linearInfl =getLayoutInflater();
                View sample = linearInfl.inflate(R.layout.sample_layer, null );
                linearLayout.addView(sample);
            }
        });
    }
}
