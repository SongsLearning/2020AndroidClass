package com.example.ex01_practice10_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex01_practice10_1.Third
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sccond.*
import kotlinx.android.synthetic.main.activity_third.*

class Third : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        button2.setOnClickListener {
            val intent = Intent(this@Third, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
