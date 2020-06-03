package com.example.javalist;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;

    // ListView에  표시될 데이터 배열
    ArrayList<String> dataList = getStringList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        //ArrayAdapter에 ListView의 하나의 아이템을 구성할 View와 데이터를 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.listview,R.id.textViewRow, dataList);

        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        // ListView에 ArrayAdapter 연결
        listView.setAdapter(adapter);

        // ListView의 각 항목을 클릭했을때, 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //textView.setText(dataArr[position]);
                textView.setText(dataList.get(position));
            }
        });


    }

    // ListView에 표시될 데이터 배열 생성 메소드
    private String[] getStringArray() {
        String[] Temp = new String[100];
        for(int i = 0; i < Temp.length; i++){
            Temp[i] = "Arr 아이템" + (i+1) ;
        }
        return Temp;
    }

    // ListView에 표시될 데이터 ArrList 생성 메소드
    private ArrayList<String> getStringList() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i = 0; i < 100; i++){
            arrayList.add("리스트 아이템" + (i + 1) );
        }
        return arrayList;
    }
}
