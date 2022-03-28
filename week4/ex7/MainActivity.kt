package com.example.applicationlab

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    var pictures : ArrayList<Int> = arrayListOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e)
    var i = 0
    lateinit var leftButton: Button
    lateinit var rightButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        leftButton = findViewById(R.id.leftButton)
        rightButton = findViewById(R.id.rightButton)
        lateinit var img : ImageView

        leftButton.setOnClickListener { movation ->
            img = findViewById(R.id.imgView)
            i = (i - 1) % 5
            if (i < 0) i = 4
            img.setImageResource(pictures[i])
        }

        rightButton.setOnClickListener{ movation ->
            img = findViewById(R.id.imgView)
            i = (i + 1) % 5
            img.setImageResource(pictures[i])
        }
    }
}
