package com.example.week6ex4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        var name:TextView = findViewById(R.id.name)
        var age:TextView = findViewById(R.id.age)
        var number:TextView = findViewById(R.id.number)
        var address:TextView = findViewById(R.id.address)
        var others:TextView = findViewById(R.id.others)
        var modify:Button = findViewById(R.id.modify)
        var finish:Button = findViewById(R.id.finish)

        val intent = getIntent()
        val array = intent.getStringArrayExtra("data")
        name.text = array?.get(0).toString()
        age.text = array?.get(1).toString()
        number.text = array?.get(2).toString()
        address.text = array?.get(3).toString()
        others.text = array?.get(4).toString()
        finish.setOnClickListener { movation ->
            val intent = Intent()
            startActivityForResult(intent)

        }
        modify.setOnClickListener{ movation ->
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}