package com.tynikat.phone_phonics

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun loadQuestions(): Array<Question> {
            val string = assets.open("data.json")
            val json = string.bufferedReader()
            val jString = json.readText()
            string.close()
            val data = Data()
            return data.getData(jString)
        }

        val questionList = loadQuestions()
        var q = getAnyQuestion(questionList)

        fun setQuestion(q: Question) {
            val options = getOptions(q)
            val imgID = resources.getIdentifier(q.name, "drawable", this.packageName)
            questionIamge.setImageResource(imgID)
            questionText.text = q.text
            option1.text = options[0]
            option2.text = options[1]
            option3.text = options[2]
            option4.text = options[3]
        }

        fun wrongAnswer() {
            questionText.text = "X"
            Timer().schedule(1000) {
                questionText.text = q.text
            }
        }

        fun rightAnswer() {
            val mp: MediaPlayer? = MediaPlayer.create(applicationContext, R.raw.success)
            mp?.start()
            questionText.text = q.name
            q = getUniqueQuestion(q, questionList)

            Timer().schedule(1000) {
                mp?.release()
                questionText.text = q.text
                runOnUiThread {
                    setQuestion(q)
                }
            }
        }

        fun checkAnswer(answer: String) {
            if (answer == q.phonic) {
                rightAnswer()
            } else {
                wrongAnswer()
            }
        }

        setQuestion(q)

        option1.setOnClickListener { checkAnswer(option1.text.toString()) }
        option2.setOnClickListener { checkAnswer(option2.text.toString()) }
        option3.setOnClickListener { checkAnswer(option3.text.toString()) }
        option4.setOnClickListener { checkAnswer(option4.text.toString()) }
    }

}

//    fun playSound() {
//        try {
//            p.setDataSource("raw/chicken_wrong.mp3")
//            p.prepare()
//        } catch (e: Exception) {
//            print("error! " + e.message)
//        }
//        p.start()
//    }