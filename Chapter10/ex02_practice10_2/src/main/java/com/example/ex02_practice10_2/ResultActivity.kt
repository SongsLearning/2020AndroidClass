package com.example.ex02_practice10_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = getIntent()

        var imageNames = intent.getStringArrayExtra("nameData")
        var voteResult = intent.getIntArrayExtra("voteData")



    }
}
