package com.example.practice02_practice8_1;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editText;
    Button btnWriter;
    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        editText = findViewById(R.id.editText);
        btnWriter = findViewById(R.id.btnWriter);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        datePicker.init(year,month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                filename = String.format("%d_%d_%d.txt", year, monthOfYear, dayOfMonth);
                String str = readDiary1(filename);
                editText.setText(str);
                btnWriter.setEnabled(true);
            }
        });

        btnWriter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getFileStreamPath(filename), false))) {
                    bufferedWriter.write(editText.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


       
    }

    private String readDiary1(String fileName) {
        String str = null;

        try( BufferedReader bufferedReader = new BufferedReader(new FileReader(getFileStreamPath(fileName)))){
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }

    private void writeDiary(String fileName){
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE))){
            outputStreamWriter.write(editText.getText().toString());
            Toast.makeText(MainActivity.this, "complate", Toast.LENGTH_SHORT).show();
            editText.setText(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
