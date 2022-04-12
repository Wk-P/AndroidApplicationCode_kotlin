package com.example.week6ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.button)

        btn.setOnClickListener{ movation ->
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }
}