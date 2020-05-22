package com.example.ex01_practice10_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sccond.*

class SccondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sccond)

        btnReturn3.setOnClickListener {
            val intent = Intent(this@SccondActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
