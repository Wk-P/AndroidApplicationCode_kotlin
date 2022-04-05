package com.example.week5ex7

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var edit: EditText
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var btnv: Button
    lateinit var btnb: Button
    lateinit var btnc: Button
    lateinit var btnl: Button
    lateinit var btnr: Button
    lateinit var btn0: Button
    var counter = 0
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit = findViewById(R.id.edit)
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        btn4 = findViewById(R.id.button4)
        btn5 = findViewById(R.id.button5)
        btn6 = findViewById(R.id.button6)
        btn7 = findViewById(R.id.button7)
        btn8 = findViewById(R.id.button8)
        btn9 = findViewById(R.id.button9)
        btn0 = findViewById(R.id.button0)
        btnl = findViewById(R.id.buttonl)
        btnr = findViewById(R.id.buttonr)
        btnv = findViewById(R.id.buttonv)
        btnc = findViewById(R.id.buttonc)
        btnb = findViewById(R.id.buttonb)
            try {
                btn1.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-1"))
                    } else {
                        edit.setText(edit.text.toString().plus("1"))
                    }
                    counter++
                }

                btn2.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-2"))
                    } else {
                        edit.setText(edit.text.toString().plus("2"))
                    }
                    counter++
                }

                btn3.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-3"))
                    } else {
                        edit.setText(edit.text.toString().plus("3"))
                    }
                    counter++
                }
                btn4.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-4"))
                    } else {
                        edit.setText(edit.text.toString().plus("4"))
                    }
                    counter++
                }
                btn5.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-5"))
                    } else {
                        edit.setText(edit.text.toString().plus("5"))
                    }
                    counter++
                }
                btn6.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-6"))
                    } else {
                        edit.setText(edit.text.toString().plus("6"))
                    }
                    counter++
                }
                btn7.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-7"))
                    } else {
                        edit.setText(edit.text.toString().plus("7"))
                    }
                    counter++
                }
                btn8.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-8"))
                    } else {
                        edit.setText(edit.text.toString().plus("8"))
                    }
                    counter++
                }
                btn9.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-9"))
                    } else {
                        edit.setText(edit.text.toString().plus("9"))
                    }
                    counter++
                }
                btn0.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-0"))
                    } else {
                        edit.setText(edit.text.toString().plus("0"))
                    }
                    counter++
                }
                btnl.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-*"))
                    } else {
                        edit.setText(edit.text.toString().plus("*"))
                    }
                    counter++
                }
                btnr.setOnClickListener { movation ->
                    if (counter == 3 || counter == 7) {
                        edit.setText(edit.text.toString().plus("-#"))
                    } else {
                        edit.setText(edit.text.toString().plus("#"))
                    }
                    counter++
                }
                btnv.setOnClickListener { movation ->
                }
                btnb.setOnClickListener { movation ->
                    val temp: String = edit.text.toString()
                    if (temp == "") {
                        edit.setText("")
                        counter = 0
                    } else {
                        if (counter == 4 || counter == 8) {
                            edit.setText(temp.subSequence(0, temp.length - 2))

                        } else {
                            edit.setText(temp.subSequence(0, temp.length - 1))
                        }
                        counter--
                    }
                }
            } catch (e: Exception) {
        }
    }
}