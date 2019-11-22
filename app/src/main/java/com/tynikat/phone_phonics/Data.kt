package com.tynikat.phone_phonics
import com.google.gson.Gson


class Data {

    fun getData(String: String): Array<Question> {

        val gSon = Gson()
        return gSon.fromJson(String, Array<Question>::class.java)
    }
}