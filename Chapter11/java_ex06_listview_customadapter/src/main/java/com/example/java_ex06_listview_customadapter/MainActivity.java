package com.example.java_ex06_listview_customadapter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    Button btnAdd;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);


        // list view data
        final ArrayList<String> dataList = getArrayListData(5);
        // adapter
        final CustomAdapter adapter = new CustomAdapter(this, R.layout.row, dataList);

        // list view link adapter
        listView.setAdapter(adapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //edittext 의 텍스트 존재 여부 확인
                if (editText.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this,"먼저 문자열을 입력",Toast.LENGTH_SHORT).show();
                    return;
                }
                dataList.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
                editText.setText("");


            }
        });
    }

    private ArrayList<String> getArrayListData(int count) {
        ArrayList<String> arrayList = new ArrayList<String>();

        for (int i = 0; i <= count; i++) {
            arrayList.add("list item" + i);
        }
        return arrayList;
    }
}
