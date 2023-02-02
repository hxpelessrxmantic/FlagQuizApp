package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnStart: Button
    lateinit var edtName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btnStart)
        edtName = findViewById(R.id.edtName)
        btnStart.setOnClickListener {
            if(edtName.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, questions::class.java)
                intent.putExtra(Constants.username, edtName.text.toString(), )
                startActivity(intent)
                finish() //close activity
            }
        }
    }
}