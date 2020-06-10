package com.example.java_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    Button btnWrite;
    Button btnRead;

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = findViewById(R.id.btWrite);
        btnRead = findViewById(R.id.btnRead);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getFileStreamPath("myFile.txt"), false))){

                    bufferedWriter.write(editText.getText().toString());
                    editText.setText(null);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try (BufferedReader bufferedReader= new BufferedReader(new FileReader(getFileStreamPath("myFile.txt")))){
                    textView.setText(bufferedReader.readLine());
                    

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
