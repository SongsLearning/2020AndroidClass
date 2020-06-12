package com.example.java_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    EditText e2;
    TextView t;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        t = findViewById(R.id.t);

        button = findViewById(R.id.buttonpp);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double one = Double.parseDouble(e1.getText().toString());
                double two = Double.parseDouble(e2.getText().toString());
                double a = one * two;

                t.setText(String.valueOf(a));
            }
        });
    }
}
