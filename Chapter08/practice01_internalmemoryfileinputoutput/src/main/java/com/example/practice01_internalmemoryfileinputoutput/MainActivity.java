package com.example.practice01_internalmemoryfileinputoutput;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

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
        textView = findViewById(R.id.textView);


        // region
        View.OnClickListener listener1 =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnWrite:
                        FileOutputStream fos = null;
                        try {
                            fos = new FileOutputStream(getFileStreamPath("myFile.txt"),true);

                            String string = editText.getText().toString();

                            fos.write(string.getBytes());


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        finally {
                            try{
                                fos.close();
                            }
                            catch (IOException e){
                                e.printStackTrace();
                            }
                        }

                        break;
                    case R.id.btnRead:


                        try( FileInputStream fis = new FileInputStream(getFileStreamPath("myFile.txt"));){


                            //textView.setText(String.valueOf(fis.read()));
//                            String str = "";
//                            int tmp;
//                            while ((tmp = fis.read()) != -1){
//                                str += (char)tmp;
//                            }

                            byte[] byteArray = new byte[20];
                            fis.read(byteArray);
                            textView.setText(new String(byteArray));

                            textView.setText(new String(byteArray));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        };

        // endregion


        //region
        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnWrite:
                        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("myFile.txt", Context.MODE_PRIVATE))){
                          outputStreamWriter.write(editText.getText().toString());
                          Toast.makeText(MainActivity.this, "complate", Toast.LENGTH_SHORT).show();
                          editText.setText(null);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case R.id.btnRead:
                        try( InputStreamReader inputStreamReader = new InputStreamReader(openFileInput("myFile.txt"))){
                            String str = "";

                            int temp;
                            while((temp = inputStreamReader.read())!= -1){
                                str+=(char)temp;
                            }
                            textView.setText(str);
                        }catch (IOException e){
                            e.printStackTrace();
                        }

                        break;
                }
            }
        };

        //endregion

        //region

        View.OnClickListener listener3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnWrite:

                        try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getFileStreamPath("myFile.txt"),false))){
                           bufferedWriter.write(editText.getText().toString());
                           editText.setText(null);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        break;
                    case R.id.btnRead:
                        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(getFileStreamPath("myFile.txt")))){
                            textView.setText(bufferedReader.readLine());


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        };
        //endregion
        btnWrite.setOnClickListener(listener3);
        btnRead.setOnClickListener(listener3);
    }
}

