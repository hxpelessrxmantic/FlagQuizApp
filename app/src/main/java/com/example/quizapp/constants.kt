package com.example.quizapp

object Constants{
    const val username: String = "username"
    const val totalquest: String = "totalquest"
    const val correctans: String = "correctans"
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val ques1 = Question(1, "What country has this flag?",R.drawable.ar,
            "Argentina", "Australia", "Jamaica", "Austria",
            1)

        questionsList.add(ques1)

        val ques2 = Question(2, "What country has this flag?",R.drawable.af,
            "Brazil", "Belgium", "Afghanistan", "Canada",
            3)

        questionsList.add(ques2)

        val ques3 = Question(3, "What country has this flag?",R.drawable.br,
            "Chile", "Cuba", "Croatia", "Brazil",
            4)

        questionsList.add(ques3)

        val ques4 = Question(4, "What country has this flag?",R.drawable.eg,
            "Argentina", "Egypt", "Iceland", "Italy",
            2)

        questionsList.add(ques4)

        val ques5 = Question(5, "What country has this flag?",R.drawable.`in`,
            "India", "Niger", "Kenya", "Pakistan",
            1)

        questionsList.add(ques5)

        val ques6 = Question(6, "What country has this flag?",R.drawable.jp,
            "Monaco", "Japan", "South Korea", "Peru",
            2)
        questionsList.add(ques6)
        val ques7 = Question(7, "What country has this flag?",R.drawable.nz,
            "Australia", "Norway", "Netherlands", "New Zealand",
            4)
        questionsList.add(ques7)
        val ques8 = Question(8, "What country has this flag?",R.drawable.za,
            "Syria", "Sweden", "South Africa", "Thailand",
            3)
        questionsList.add(ques8)
        val ques9 = Question(9, "What country has this flag?",R.drawable.nl,
            "Netherlands", "Philippines", "Oman", "Puerto Rico",
            1)
        questionsList.add(ques9)
        val ques10 = Question(10, "What country has this flag?",R.drawable.sd,
            "Poland", "Nigeria", "Taiwan", "Sudan",
            4)
        questionsList.add(ques10)
        return questionsList
    }
}