package com.example.ex01_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //DATA Arr


    private fun getStringArray(): Array<String> {

        return Array(100){ i->i.toString()+"hi"}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dataArr = getStringArray()

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dataArr)


        // lastView ArrayAdapter connect

        listView.adapter = adapter

        listView.setOnItemClickListener{
            parent, view, position, id ->
            textView.setText(dataArr[position])
        }


    }
}
