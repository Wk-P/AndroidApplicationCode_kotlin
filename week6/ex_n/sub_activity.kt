package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    lateinit var text: TextView
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        setTitle("Sub Activitty")

        val intent = getIntent()
        text = findViewById(R.id.Text)
        text.setText(intent.getStringExtra("data").toString())
        btn = findViewById(R.id.button)
        btn.setOnClickListener{ movation ->
            intent.putExtra("data", "Hi")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
