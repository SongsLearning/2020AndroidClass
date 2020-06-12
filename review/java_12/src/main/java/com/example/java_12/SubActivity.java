package com.example.java_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.textView);
        Intent intent = getIntent();

        String str = intent.getStringExtra("str");

        textView.setText(str);

        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                String s = "";
                if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton) {
                    s = "one";
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton2) {
                    s = "two";
                }
                in.putExtra("radio",s);
                setResult(RESULT_OK, in);
                finish();
            }
        });

        radioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = radioGroup.getCheckedRadioButtonId();

                if (id == R.id.radioButton) {
                    // 전화걸기
                    Uri uri = Uri.parse("tel:0629496800");
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(intent);
                    // 카메라 실행
                } else if (id == R.id.radioButton2) {


                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                    startActivity(intent);
                }
            }
        });

    }
}
