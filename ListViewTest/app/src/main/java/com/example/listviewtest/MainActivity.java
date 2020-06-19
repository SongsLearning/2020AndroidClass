package com.example.listviewtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    Button btnModify;
    Button btnDel;

    TextView textView;
    ListView listView;

    int select = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnModify = findViewById(R.id.btnModi);
        btnDel = findViewById(R.id.btnDel);
        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        final ArrayList<String> data = getData();


        final ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_single_choice, data);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        textView.setText(data.get(0));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(data.get(position));
                select = position;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add("리스트 아이템"+(data.size()+1));
                adapter.notifyDataSetChanged();
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(select);
                adapter.notifyDataSetChanged();

            }
        });
        final Context context = this;
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(getApplicationContext());

                new AlertDialog.Builder(context)
                        .setTitle("리스트 아이템 수정")
                        .setMessage("현재 데이터 : " + data.get(select))

                        .setIcon(R.mipmap.ic_launcher_round)
                        .setView(editText)
                        .setCancelable(false)
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("수정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                data.set(select, editText.getText().toString());
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        });
    }

    private ArrayList<String> getData() {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add("리스트 데이터 " + (i + 1));
        }
        return arr;
    }
}
