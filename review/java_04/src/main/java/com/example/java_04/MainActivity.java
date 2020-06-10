package com.example.java_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.one_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Item1:
                textView.setText("item1");
                break;
            case R.id.Item2:

                textView.setText("item2");
                break;
            case R.id.Item3:

                textView.setText("item3");
                break;
            case R.id.subItem1:

                textView.setText("s1");
                break;
            case R.id.subItem2:

                textView.setText("s2");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
