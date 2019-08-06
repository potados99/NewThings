package com.potados.newthings

import kotlin.random.Random

class RandomStringGenerator {
    companion object {
        private val random = Random(System.currentTimeMillis())

        fun generate(minLength: Int, maxLength: Int = minLength + 5, firstUpperCase: Boolean = true): String {
            val firstChar =  getRandomChar(upper = firstUpperCase)
            val lineLength = random.nextInt(minLength, maxLength + 1)

            val str = StringBuilder().append(firstChar)
            for (i in (1 until lineLength)) {
                str.append(getRandomChar(upper = false))
            }

            return str.toString()
        }

        private fun getRandomChar(upper: Boolean = false): Char {
            return if (upper) random.nextInt(65 /* A */, 90 /* Z */ + 1).toChar()
            else random.nextInt(97 /* a */, 122 /* z */ + 1).toChar()
        }
    }
}