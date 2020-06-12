package com.example.java02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView textView;
    RadioGroup radioGroup;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        textView = findViewById(R.id.textView);
        radioGroup = findViewById(R.id.radioG);
        button = findViewById(R.id.button);

        final Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        textView.setText(str);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                int radio = radioGroup.getCheckedRadioButtonId();
                if (radio == R.id.radio1) {
                    in.putExtra("radio","phone");


                } else if ((radio == R.id.radio2)) {
                    in.putExtra("radio","cam");

                }
                setResult(0, in);
                finish();
            }
        });

    }
}
