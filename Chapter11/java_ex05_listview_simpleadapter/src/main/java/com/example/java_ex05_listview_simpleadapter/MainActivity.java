package com.example.java_ex05_listview_simpleadapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;

    int[] imgResIds = {R.drawable.kakao01,R.drawable.kakao02,R.drawable.kakao03,
            R.drawable.kakao04,R.drawable.kakao05,R.drawable.kakao06,R.drawable.kakao07,
            R.drawable.kakao08,R.drawable.kakao09};
    ArrayList<String> titleData = getArrayListData("Title", imgResIds.length);
    ArrayList<String> contentsData = getArrayListData("contents", imgResIds.length);

    private ArrayList<String> getArrayListData(String contents, int count) {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < count; i++) {
            list.add( contents + (i + 1));
        }
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        ArrayList<HashMap<String, Object>> listViewData = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < imgResIds.length; i++) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("img", imgResIds[i]);
            hashMap.put("title", titleData.get(i));
            hashMap.put("contents", contentsData.get(i));

            listViewData.add(hashMap);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                listViewData,
                R.layout.row,
                new String[]{"img","title","contents"},
                new int[]{R.id.imageViewRow, R.id.textViewTitle, R.id.textViewRowContents}

        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(titleData.get(position));
            }
        });
    }
}
