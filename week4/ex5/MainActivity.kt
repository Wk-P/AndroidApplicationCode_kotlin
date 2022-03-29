package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var button : Button
    lateinit var layout : LinearLayout
    var colors : ArrayList<String> = arrayListOf("#00FF00", "#0000FF", "#FF0000")
    var i : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ex5)
        layout = findViewById(R.id.layout)
        button = findViewById(R.id.btn)
        button.setOnClickListener { movation ->
            layout.setBackgroundColor(Color.parseColor(colors[i]))
            i = (i + 1) % 3
        }
    }
}
