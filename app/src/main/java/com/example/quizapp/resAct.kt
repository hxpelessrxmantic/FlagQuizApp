package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class resAct : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var score: TextView
    lateinit var btnfinish: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res)

        name = findViewById(R.id.name)
        score = findViewById(R.id.score)
        btnfinish = findViewById(R.id.finish)

        val username = intent.getStringExtra(Constants.username)
        name.text = username

        val totalquestions =  intent.getIntExtra(Constants.totalquest, 0)
        val correctanswers = intent.getIntExtra(Constants.correctans, 0)
        score.text = "You scored $correctanswers out of $totalquestions"

        btnfinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}