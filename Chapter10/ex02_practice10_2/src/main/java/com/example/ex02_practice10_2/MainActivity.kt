package com.example.ex02_practice10_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var imageViews = arrayOf<ImageView>(iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        for (i in 0..imageViews.size){
            imageViews[i].setOnClickListener{

            }
        }
    }
}
