package com.example.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnWrite, btnRead;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);
        textView = findViewById(R.id.btnRead);

        View.OnClickListener listener1 =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnWrite:
                        FileOutputStream fos = null;
                        try {
                            fos = new FileOutputStream(getFileStreamPath("myFile.txt"),true);
                        } catch (FileNotFoundException e) {

                        }
                        break;
                    case R.id.btnRead:

                        break;
                }
            }
        };
        btnWrite.setOnClickListener(listener1);
        btnRead.setOnClickListener(listener1);
    }
}
