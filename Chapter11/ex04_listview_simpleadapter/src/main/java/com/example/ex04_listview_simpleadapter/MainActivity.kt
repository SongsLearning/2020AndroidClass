package com.example.ex04_listview_simpleadapter


import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var dataArr = getStringArray()

    var titleData = getStringData("title")
    var contentsData = getStringData("contents")
    val adapter = SimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listViewData = ArrayList<HashMap<String,String>>()

        for(i in 0..titleData.size)
        {
            var h = HashMap<String,String>();
            h.put("title",titleData.get(i))
            h.put("contents",contentsData.get(i))

            listViewData.add(h)
        }

        listView.choiceMode = ListView.CHOICE_MODE_SINGLE

        // lastView ArrayAdapter connect


        btnAdd.setOnClickListener(this)
        btnModify.setOnClickListener(this)
        btnDelete.setOnClickListener(this)


        listView.setOnItemClickListener{
                parent, view, position, id ->
            textView.setText(arrList.get(position))
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

    private fun getStringArray(): Array<String> {

        return Array(100){ i->i.toString()+"hi"}
    }


    override fun onClick(v: View?) {
        val count = adapter.count
        val checkedItemPostition = listView.checkedItemPosition

        if (v != null) {
            when(v.id){
                R.id.btnAdd -> {

                }

                R.id.btnModify -> {

                    val editText = EditText(applicationContext)
                    AlertDialog.Builder(applicationContext)
                        .setTitle("listView Item Edit")
                        .setMessage("select data : " + arrList.get(checkedItemPostition))
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setView(editText)
                        .setPositiveButton("Edit", DialogInterface.OnClickListener {
                                dialog, which -> arrList.set(checkedItemPostition,editText.text.toString())
                        })
                        .setNegativeButton("cancle",null)
                        .show()

                }
                R.id.btnDelete -> {
                    arrList.removeAt(checkedItemPostition)
                }
            }
            adapter.notifyDataSetChanged()
        }
    }
}
