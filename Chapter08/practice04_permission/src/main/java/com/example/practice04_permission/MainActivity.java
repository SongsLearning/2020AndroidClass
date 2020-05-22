package com.example.practice04_permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    Button btnVIBRATE;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVIBRATE = findViewById(R.id.btn);

        textView = findViewById(R.id.textView);

        btnVIBRATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

                vibrator.vibrate(2000);

            }
        });

        String[] permissionList = {
        };

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            textView.setText("권한이없음");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},0 );
        }
        else {
            textView.setText("권한이있음");
        }




    }
}
