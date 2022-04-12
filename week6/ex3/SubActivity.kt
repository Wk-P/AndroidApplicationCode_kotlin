package com.example.week6ex3

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val name: TextView = findViewById(R.id.name)
        val age: TextView = findViewById(R.id.age)
        val address: TextView = findViewById(R.id.address)
        val number: TextView = findViewById(R.id.number)
        val others: TextView = findViewById(R.id.others)
        val finish: Button = findViewById(R.id.finish)

        val intent = getIntent()
        val array = intent.getStringArrayExtra("data")
        name.text = array?.get(0).toString()
        age.text = array?.get(1).toString()
        number.text = array?.get(2).toString()
        address.text = array?.get(3).toString()
        others.text = array?.get(4).toString()
        finish.setOnClickListener { movation ->
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}