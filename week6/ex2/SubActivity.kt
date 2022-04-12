package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val btn: Button = findViewById(R.id.btn_sub)
        val ev = findViewById<EditText>(R.id.ev_sub)
        val res:TextView = findViewById(R.id.res_sub)
        val intent = getIntent()

        if (intent != null) {
            res.text = intent!!.getStringExtra("data").toString() + "\n-send from main"
        }

        btn.setOnClickListener{ movation ->
            if (ev.text.isEmpty()) {
                Toast.makeText(this, "값을 입력 해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val data:String = ev.text.toString()
            intent.putExtra("data", data)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
