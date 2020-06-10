package com.example.java_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnNew;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNew = findViewById(R.id.btnNew);

        radioGroup = findViewById(R.id.group);


        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = radioGroup.getCheckedRadioButtonId();

                if (id == R.id.Second) {
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(intent);
                } else if (id == R.id.Third) {
                    Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "액티비티 선택", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
