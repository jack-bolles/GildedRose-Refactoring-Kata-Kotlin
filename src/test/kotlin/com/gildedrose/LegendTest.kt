package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LegendTest {

    @Test
    fun `legendary items never expire`() {
        val dayZero = listOf(
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
        )

        val nextDay = listOf(
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
        )

        assertEquals(nextDay, dayZero.ageFor(1))
    }
}
