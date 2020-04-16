package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText Num1, Num2;
    Button Btn1, Btn2, Btn3, Btn4;
    TextView Result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = findViewById(R.id.editTextNum1);
        Num2 = findViewById(R.id.editTextNum2);

        Btn1 = findViewById(R.id.btnAdd);
        Btn2 = findViewById(R.id.btnSubtract);
        Btn3 = findViewById(R.id.btnMultiply);
        Btn4 = findViewById(R.id.btnDivide);

        Result = findViewById(R.id.textViewResult);

        @SuppressLint("SetTextI18n") View.OnClickListener cal = v -> {
            if (Num1.getText().toString().equals("") || Num2.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "값을 입력해주세요.", Toast.LENGTH_SHORT).show();
            } else {
                double res = 0;
                switch (v.getId()) {
                    case R.id.btnAdd:
                        res = Double.parseDouble(Num1.getText().toString()) + Double.parseDouble(Num2.getText().toString());
                        break;

                    case R.id.btnSubtract:
                        res = Double.parseDouble(Num1.getText().toString()) - Double.parseDouble(Num2.getText().toString());
                        break;

                    case R.id.btnMultiply:
                        res = Double.parseDouble(Num1.getText().toString()) * Double.parseDouble(Num2.getText().toString());
                        break;

                    case R.id.btnDivide:
                        res = Double.parseDouble(Num1.getText().toString()) / Double.parseDouble(Num2.getText().toString());
                        break;
                }
                Result.setText("계산결과 : " + res);
            }
        };

        Btn1.setOnClickListener(cal);
        Btn2.setOnClickListener(cal);
        Btn3.setOnClickListener(cal);
        Btn4.setOnClickListener(cal);
    }
}
      