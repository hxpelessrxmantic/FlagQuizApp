package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class questions : AppCompatActivity(), View.OnClickListener {

    //questions variables
    lateinit var progbar: ProgressBar
    lateinit var txtProg: TextView
    lateinit var quest: TextView
    lateinit var img: ImageView
    lateinit var opt1: TextView
    lateinit var opt2: TextView
    lateinit var opt3: TextView
    lateinit var opt4: TextView
    lateinit var btnSubmit: Button

    //ui variables
    var curpos: Int = 1
    var questList: ArrayList<Question>?=null
    var selectedpos: Int = 0
    var correctAns: Int = 0

    var username: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        progbar = findViewById(R.id.progbar)
        txtProg = findViewById(R.id.txtprog)
        quest = findViewById(R.id.quest)
        img = findViewById(R.id.img)
        opt1 = findViewById(R.id.opt1)
        opt2 = findViewById(R.id.opt2)
        opt3 = findViewById(R.id.opt3)
        opt4 = findViewById(R.id.opt4)
        btnSubmit = findViewById(R.id.btnSubmit)

        username = intent.getStringExtra(Constants.username)

        questList = Constants.getQuestions()
        setQuestion()
        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
    }
    private fun setQuestion(){
        val question = questList!![curpos-1]
        defaultoptview()

        if (curpos == questList!!.size){
            btnSubmit.text = "Finish"
        }else{
            btnSubmit.text = "Submit"
        }
        progbar.progress = curpos
        txtProg.text = "$curpos" + "/" + progbar.max
        quest.text = question!!.question
        img.setImageResource(question.image)
        opt1.text = question.option1
        opt2.text = question.option2
        opt3.text = question.option3
        opt4.text = question.option4
    }

    private fun defaultoptview(){
        val options = ArrayList<TextView>()
        options.add(0, opt1)
        options.add(1, opt2)
        options.add(2, opt3)
        options.add(3, opt4)

        for (option in options){
            option.setTextColor(Color.parseColor("#FF000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.optbor)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.opt1 -> {
                selectedoptview(opt1, 1)
            }
            R.id.opt2 -> {
                selectedoptview(opt2, 2)
            }
            R.id.opt3 -> {
                selectedoptview(opt3, 3)
            }
            R.id.opt4 -> {
                selectedoptview(opt4, 4)
            }
            R.id.btnSubmit -> {
                if(selectedpos == 0){
                    curpos++
                    when{
                        curpos <= questList!!.size -> {
                            setQuestion()
                        }else -> {
                            val intent = Intent(this, resAct::class.java)
                        intent.putExtra(Constants.username, username)
                        intent.putExtra(Constants.correctans, correctAns)
                        intent.putExtra(Constants.totalquest, questList!!.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                }else{
                    val question = questList?.get(curpos -1)
                    if(question!!.correctAns != selectedpos){
                        ansView(selectedpos, R.drawable.wrongopt)
                    }else{
                        correctAns++
                    }
                    ansView(question.correctAns, R.drawable.correctopt)
                    if(curpos == questList!!.size){
                        btnSubmit.text = "Finish"
                    }else{
                        btnSubmit.text = "Next"
                    }
                    selectedpos = 0
                }
            }
        }
    }
    private fun ansView(answer: Int, drawableView: Int){ //assign correct background to answers
        when(answer){
            1 -> {
                opt1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                opt2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                opt3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                opt4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
    private fun selectedoptview(txtView: TextView, selectedOptNum: Int){
        defaultoptview()
        selectedpos = selectedOptNum
        txtView.setTextColor(Color.parseColor("#FF0000"))
        txtView.setTypeface(txtView.typeface, Typeface.BOLD)
        txtView.background = ContextCompat.getDrawable(this, R.drawable.onselected)
    }
}