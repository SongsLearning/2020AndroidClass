package com.example.ch5_p;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 1. View 참조변수 생성
    Button btn_visible, btn_invisible;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. View 참조변수에 View 인스턴스 연결
        btn_visible = findViewById(R.id.visible);
        btn_invisible = findViewById(R.id.invisible);
        imageView = findViewById(R.id.imageView1);

        // 3. 버튼 클릭 이벤트 처리 1
        /*btn_visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
            }
        });

        btn_invisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.INVISIBLE);
            }
        });*/

        // 4. 버튼 클릭 이벤트 처리 2
        /*View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_visible:
                        imageView.setVisibility(View.VISIBLE);
                        break;
                    case R.id.invisible:
                        imageView.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        };

        btn_visible.setOnClickListener(listener);
        btn_invisible.setOnClickListener(listener);*/

        // 5. 버튼 클릭 이벤트 처리 3
        btn_visible.setOnClickListener(this);
        btn_invisible.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (btn_visible.equals(v))
            imageView.setVisibility(View.VISIBLE);
        else imageView.setVisibility(View.INVISIBLE);

    }
}
