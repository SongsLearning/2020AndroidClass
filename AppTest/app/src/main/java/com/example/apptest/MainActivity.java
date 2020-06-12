package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnPlus;
    Button btnMin;
    Button btnMul;
    Button btnDiv;

    EditText editText1;
    EditText editText2;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlus = findViewById(R.id.button1);
        btnMin = findViewById(R.id.button2);
        btnMul = findViewById(R.id.button3);
        btnDiv = findViewById(R.id.button4);

        editText1 = findViewById(R.id.num1);
        editText2 = findViewById(R.id.num2);

        textView = findViewById(R.id.textView);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double d1 = Double.parseDouble(editText1.getText().toString());
                Double d2 = Double.parseDouble(editText2.getText().toString());
                textView.setText("계산결과 :" + (int) (d1+d2));
            }
        });

        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double d1 = Double.parseDouble(editText1.getText().toString());
                double d2 = Double.parseDouble(editText2.getText().toString());
                textView.setText("계산결과 :" +(int) (d1-d2));
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double d1 = Double.parseDouble(editText1.getText().toString());
                double d2 = Double.parseDouble(editText2.getText().toString());
                textView.setText("계산결과 :" + (int) (d1*d2));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double d1 = Double.parseDouble(editText1.getText().toString());
                double d2 = Double.parseDouble(editText2.getText().toString());
                double r = d1 / d2;
                textView.setText("계산결과 :" + Double.toString(r));
            }
        });
    }
}
