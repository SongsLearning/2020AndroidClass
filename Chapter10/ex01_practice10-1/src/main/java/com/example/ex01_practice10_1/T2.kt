package com.example.ex01_practice10_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_t2.*

class T2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t2)


        buttonR.setOnClickListener {
            val intent = Intent(this@T2, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
