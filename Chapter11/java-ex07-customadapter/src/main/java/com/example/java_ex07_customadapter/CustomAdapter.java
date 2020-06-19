
package com.example.java_ex07_customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {

    Context context;
    int resource;
    ArrayList<ItemVO> dataList;

    public CustomAdapter(Context context, int resource, ArrayList<ItemVO> dataList) {
        this.context = context;
        this.resource = resource;
        this.dataList = dataList;
    }

    // listview의 아이템 개수 반환
    @Override
    public int getCount() {
        return dataList.size();
    }

    // listview의 아이템 반환
    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 화면에 보여지는 리스트뷰의 아이템 표시를 위한 뷰 반환
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 재사용 가능한 뷰가 없으면 생성
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, null);       // r.layout.row xml view 객체로 생성
        }
        //반환할 view 설정

        // convertVIew의 구성요소인 view들을 참조변수에 연결
        assert convertView != null;
        ImageView imageViewIcon = convertView.findViewById(R.id.imageVIewIcon);
        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);
        TextView textViewContent = convertView.findViewById(R.id.textViewContent);
        ImageView imageViewMenu = convertView.findViewById(R.id.imageVIewMenu);

        imageViewMenu.setImageResource(R.drawable.ic_menu);

        // 타입에 따라 아이콘 세팅
        switch (dataList.get(position).getTypeStr()) {
            case "doc":
                imageViewIcon.setImageResource(R.drawable.ic_type_doc);
                break;
            case "img":
                imageViewIcon.setImageResource(R.drawable.ic_type_image);
                break;
            case "file":
                imageViewIcon.setImageResource(R.drawable.ic_type_file);
                break;
        }

        // title
        textViewTitle.setText(dataList.get(position).getTitle());
        textViewContent.setText(dataList.get(position).getContentsStr());


        return convertView;
    }
}
