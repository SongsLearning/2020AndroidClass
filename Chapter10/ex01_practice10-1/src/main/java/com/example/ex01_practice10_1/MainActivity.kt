package com.example.ex01_practice10_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sccond.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMain.setOnClickListener {
            var id: Int = RadioGroup.checkedRadioButtonId
            if(id != -1)
            {
                val radio: RadioButton = findViewById(id)
                Toast.makeText(applicationContext,"On button click : ${radio.text}",
                    Toast.LENGTH_SHORT).show()

                if (radio == Sccond){
                    val intent = Intent(this@MainActivity, SccondActivity::class.java)
                    startActivity(intent)
                }
                else if (radio == Third){

                    val intent = Intent(this@MainActivity, T2::class.java)
                    startActivity(intent)
                }
            }
            else {
                Toast.makeText(this@MainActivity, "선택바람", Toast.LENGTH_SHORT).show()
            }



        }
    }
}
