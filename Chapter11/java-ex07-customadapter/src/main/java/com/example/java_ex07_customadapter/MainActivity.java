package com.example.java_ex07_customadapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    Button btnAdd;

    ArrayList<ItemVO> dataList = new ArrayList<ItemVO>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewHead);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);


        // listview 에 표시할 초기 데이터
        dataList.add(new ItemVO("doc", "Document 1", "sample data"));
        dataList.add(new ItemVO("img", "image 1", "sample data"));
        dataList.add(new ItemVO("file", "file 1", "sample data"));

        // 커스텀 어뎁터 객체 생성
        final CustomAdapter adapter = new CustomAdapter(this, R.layout.row, dataList);

        // listview 어뎁터 연결
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(dataList.get(position).getTitle());

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                final View view = inflater.inflate(R.layout.alertdialog_add_item, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("list item add")
                        .setMessage("문서 종류 선택")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setView(view)
                        .setPositiveButton("check", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String type = null, title, content;

                                int checkedId = ((RadioGroup)view.findViewById(R.id.radioGroup)).getCheckedRadioButtonId();

                                switch (checkedId) {
                                    case R.id.rbDoc:
                                        type = "doc";
                                        break;
                                    case R.id.rbImg:
                                        type = "img";
                                        break;
                                    case R.id.rbFile:
                                        type = "file";
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + checkedId);
                                }
                                title = ((EditText) view.findViewById(R.id.editTextTitle)).getText().toString();
                                content = ((EditText) view.findViewById(R.id.editTextContent)).getText().toString();
                                
                                dataList.add(new ItemVO(type, title, content));
                                adapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("cancle",null)
                        .show();
            }
        });

    }
}
