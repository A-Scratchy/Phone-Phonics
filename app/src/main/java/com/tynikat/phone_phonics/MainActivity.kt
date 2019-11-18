package com.tynikat.phone_phonics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.media.MediaPlayer
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        option1.setOnClickListener {
            questionIamge.setImageResource(R.drawable.chicken_wrong)
            val mp: MediaPlayer? = MediaPlayer.create(applicationContext, R.raw.chicken_wrong)
            mp?.start() // no need to call prepare(); create() does that for you

            Timer().schedule(1000) {
                questionIamge.setImageResource(R.drawable.chicken)
            }
        }

        option2.setOnClickListener {
            questionIamge.setImageResource(R.drawable.chicken_wrong)
            val mp: MediaPlayer? = MediaPlayer.create(applicationContext, R.raw.chicken_wrong)
            mp?.start() // no need to call prepare(); create() does that for you

            Timer().schedule(1000) {
                questionIamge.setImageResource(R.drawable.chicken)
            }
        }

        option3.setOnClickListener {

            val mp: MediaPlayer? = MediaPlayer.create(applicationContext, R.raw.success)
            mp?.start() // no need to call prepare(); create() does that for you

            questionText.text = "chicken"

            Timer().schedule(3000) {
                questionText.text = "__icken"
            }
        }

        option4.setOnClickListener {
            questionIamge.setImageResource(R.drawable.chicken_wrong)
            val mp: MediaPlayer? = MediaPlayer.create(applicationContext, R.raw.chicken_wrong)
            mp?.start() // no need to call prepare(); create() does that for you

            Timer().schedule(1000) {
                questionIamge.setImageResource(R.drawable.chicken)
            }
        }

    }


}
