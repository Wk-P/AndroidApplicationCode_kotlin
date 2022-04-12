package com.example.week6ex4

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val GALLERY = 1
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

        val image: ImageView = findViewById(R.id.img)
        image.isClickable = true
        image.setOnClickListener {
            openGallery()
        }
        save.setOnClickListener{ movation ->
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

    private fun openGallery() {
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, GALLERY)
    }

    private fun resizeBitmap(bitmap:Bitmap, width:Int, height:Int):Bitmap{
        return Bitmap.createScaledBitmap(
            bitmap, width, height, false
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                GALLERY-> {
                    var ImageData: Uri? = data?.data
                    try {
                        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData)
                        val pt: ImageView = findViewById(R.id.img)
                        pt.setImageBitmap(bitmap)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}