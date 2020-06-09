package com.example.java_ex06_listview_customadapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {

    Context context;
    int resource;
    ArrayList<String> dataList;

    public CustomAdapter(Context context, int resource, ArrayList<String> dataList) {
        this.context = context;
        this.resource = resource;
        this.dataList = dataList;
    }

    @Override

    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //display view
    //화면에 항목이 보여질떄 호출됨, 화면에 보여지는 개수만큼호출

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // 재활용 가능한 view 가 없다면 새로운 view 생성

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, null);
        }

        // 반환할 view 객체 설정
        TextView textViewRow = convertView.findViewById(R.id.textViewRow);
        textViewRow.setText(dataList.get(position));



        Button btnModify = convertView.findViewById(R.id.btnModify);
        Button btnDelete = convertView.findViewById(R.id.btnDelete);

        //
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(context);
                new AlertDialog.Builder(context)
                        .setTitle("list item modify")
                        .setMessage("select data:" + dataList.get(position))
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setView(editText)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataList.set(position, editText.getText().toString());
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("cancle",null)
                        .show();
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("list item del")
                        .setMessage(dataList.get(position) + "del")
                        .setIcon(R.mipmap.ic_launcher_remove)
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataList.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("no", null)
                        .show();
            }
        });

        return convertView;
    }
}
