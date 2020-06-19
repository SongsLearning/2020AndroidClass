package com.example.list_test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView selectedListItem;
    ListView listView;
    Button addBtn, editBtn, delBtn;
    int selNum;


    final ArrayList<String> dataSet = getString();
    ArrayList<String> getString(){
        ArrayList<String> dataSet = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            dataSet.add("listdata"+(i+1));
        }
        return dataSet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedListItem = findViewById(R.id.selectedListItem);
        listView = findViewById(R.id.listView);
        addBtn = findViewById(R.id.addBtn);
        editBtn = findViewById(R.id.editBtn);
        delBtn = findViewById(R.id.delBtn);

        //listview 의 초기 출력
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_single_choice, dataSet
        );
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);



        //요구사항 초기값은 리스트데이터

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.add("list data" + (dataSet.size()+1));
                adapter.notifyDataSetChanged();         //갱신
            }
        });

        // 요구사항 중 선택된 이스트 아이템을 수정
        // 무엇이 선택되었는지 판단
        // 선택된 위치의 내용 수정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selNum = position;
                selectedListItem.setText(dataSet.get(position));

            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("list data modify")
                        .setMessage(dataSet.get(selNum))
                        .setIcon(R.mipmap.ic_launcher_round);
                final EditText et = new EditText(getApplicationContext());
                dlg.setView(et);
                dlg.setNegativeButton("Cancle",null)
                        .setPositiveButton("check", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataSet.set(selNum, et.getText().toString());
                                selectedListItem.setText(dataSet.get(selNum));

                                adapter.notifyDataSetChanged();
                            }
                        }).show();
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.remove(selNum);
                selectedListItem.setText(dataSet.get(selNum));

                adapter.notifyDataSetChanged();
            }
        });
    }

}
