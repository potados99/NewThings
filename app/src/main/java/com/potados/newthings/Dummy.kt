package com.potados.newthings

import kotlin.random.Random

object Dummy {

    data class DummyItem(
        val id: Int,
        val title: String,
        val description: String
        )

    private val numberOfDummies = 30
    private val dummies = mutableListOf<DummyItem>()

    init {
        fill()
    }

    private fun fill() {

        for (id in (0 until 30)) {
            dummies.add(
                DummyItem(
                    id,
                    RandomStringGenerator.generate(10, 15, true),
                    RandomStringGenerator.generate(10, 100, false)
                )
            )
        }
    }

    fun newDummyItems(): List<DummyItem> {
        dummies.clear()
        fill()
        return dummies
    }
}