package com.tynikat.phone_phonics
import android.content.Context
import kotlinx.android.synthetic.main.activity_main.*

private val phonicsP3 = listOf(
        "j",
        "n",
        "w",
        "x",
        "y",
        "z",
        "zz",
        "qu",
        "ch",
        "sh",
        "th",
        "ng",
        "ai",
        "ee",
        "igh",
        "oa",
        "oo",
        "ar",
        "or",
        "ur",
        "ow",
        "oi",
        "ear",
        "air",
        "ure",
        "er"
    )

    fun getOptions(q: Question): MutableList<String> {
        // get question and add correct phonic to list
        val options = mutableListOf(q.phonic)
        // generate 3 random phonics and add them
        for (num in (0..2)) {
            val j = (0..phonicsP3.size - 1).random()
            options.add(phonicsP3[j])
        }
        // shuffle options
        options.shuffle()
        return options
    }

    fun getRandNotX(x: Int, size: Int): Int {
        var i = (0..size).random()
        if (i == x) {
            i = getRandNotX(x, size)
        }
        return i
    }

    fun getUniqueQuestion(q: Question, qList: Array<Question>): Question {
        val i = getRandNotX(qList.indexOf(q), qList.size-1)
        // get question data
        return qList[i]
    }

    fun getAnyQuestion(qList: Array<Question>): Question {
        var i = (0..(qList.size-1)).random()
        // get question data
        return qList[i]
    }

//val mp: MediaPlayer? = MediaPlayer.create(applicationContext, R.raw.chicken_wrong)
//mp?.start()
//mp?.release()

//Timer().schedule(1000) {}

//Timer().schedule(1000) {}
