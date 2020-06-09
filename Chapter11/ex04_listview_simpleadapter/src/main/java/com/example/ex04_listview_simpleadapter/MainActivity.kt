package com.example.ex04_listview_simpleadapter


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var titleData = getStringArray("tt")
        var contentsData = getStringArray("con")

        var listViewData = ArrayList<HashMap<String,String>>()

        for(i in titleData.indices)
        {
            var h = HashMap<String,String>();
            h.put("title",titleData.get(i))
            h.put("contents",contentsData.get(i))
            listViewData.add(h)
        }

        val keys = arrayOf<String>("title","contents")

        val ids = intArrayOf(android.R.id.text1,android.R.id.text2)

        val adapter = SimpleAdapter(this, listViewData,
                android.R.layout.simple_list_item_2
                ,keys, ids)

        listView.adapter = adapter

        listView.choiceMode = ListView.CHOICE_MODE_SINGLE

        // lastView ArrayAdapter connect

        listView.setOnItemClickListener { parent, view, position, id ->
            textView.setText(titleData.get(position) + " : " + contentsData.get(position))
        }



    }

    private fun getStringData(vararg str : String): ArrayList<String>{
        val a = ArrayList<String>()
        for (i in 0..5)
        {
            a.add("a" + (i+1))
        }
        return a
    }

    private fun getStringArray(s: String): Array<String> {

        return Array(5){ i->i.toString()+s}
    }


}


