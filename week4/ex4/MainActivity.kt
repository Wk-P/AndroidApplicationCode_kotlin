package com.example.myapplication

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
    lateinit var textResult : TextView
    lateinit var num1 : String
    lateinit var num2 : String
    var result : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "초간단 계산기"

        edit1 = findViewById(R.id.Edit1)
        edit1 = findViewById(R.id.Edit2)
        btnAdd = findViewById(R.id.AddBtn)
        btnSub = findViewById(R.id.SubBtn)
        btnMul = findViewById(R.id.MulBtn)
        btnDiv = findViewById(R.id.DivBtn)
        textResult = findViewById(R.id.TextResult)

        btnAdd.setOnTouchListener{ view, movation ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnSub.setOnTouchListener{ view, movation ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnMul.setOnTouchListener{ view, movation ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnDiv.setOnTouchListener{ view, movation ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }
    }
}
