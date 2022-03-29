package com.example.week4ex8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var btnExc : Button
    lateinit var textResult : TextView
    lateinit var num1 : String
    lateinit var num2 : String
    var result : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Homework"

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)
        btnAdd = findViewById(R.id.AddBtn)
        btnSub = findViewById(R.id.SubBtn)
        btnMul = findViewById(R.id.MulBtn)
        btnDiv = findViewById(R.id.DivBtn)
        btnExc = findViewById(R.id.ExcBtn)
        textResult = findViewById(R.id.TextResult)

        btnAdd.setOnTouchListener{ view, movation ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            try {
                result = Integer.parseInt(num1) + Integer.parseInt(num2)
            } catch (e: Exception) {
                println("No number!")
            }
            textResult.text = "계산 결과 : " + result.toString()
            edit1.setText(result.toString())
            edit2.setText(null)
            false
        }

        btnSub.setOnTouchListener{ view, movation ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            try {
                result = Integer.parseInt(num1) - Integer.parseInt(num2)
            } catch (e: Exception) {
                println("No number!")
            }
            edit1.setText(result.toString())
            edit2.setText(null)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnMul.setOnTouchListener{ view, movation ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            try {
                result = Integer.parseInt(num1) * Integer.parseInt(num2)
            } catch (e: Exception) {
                println("No number!")
            }
            edit1.setText(result.toString())
            edit2.setText(null)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnDiv.setOnTouchListener{ view, movation ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            try {
                result = Integer.parseInt(num1) / Integer.parseInt(num2)
            } catch (e: Exception) {
                println("No number!")
            }
            edit1.setText(result.toString())
            edit2.setText(null)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnExc.setOnClickListener{ movation ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            edit1.setText(num2)
            edit2.setText(num1)
            false
        }
    }
}
