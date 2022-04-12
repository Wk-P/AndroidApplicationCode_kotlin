package com.example.week6ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var number: EditText
    lateinit var address: EditText
    lateinit var others: EditText
    lateinit var save: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        age = findViewById(R.id.age)
        number = findViewById(R.id.number)
        others = findViewById(R.id.others)
        address = findViewById(R.id.address)
        save = findViewById(R.id.save)


        save.setOnClickListener{
            val pflag = name.text.isEmpty() || age.text.isEmpty() || number.text.isEmpty() || others.text.isEmpty() || address.text.isEmpty()
            if (pflag) {
                Toast.makeText(this,"Please input on the white space!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val data: Array<String> = arrayOf(name.text.toString(), age.text.toString(), number.text.toString(), address.text.toString(), others.text.toString())
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("data", data)
            startActivityForResult(intent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}