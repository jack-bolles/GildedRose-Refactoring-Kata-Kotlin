package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LegendTest {

    @Test
    fun `legendary items never expire`() {
        val dayZeroPasses = listOf(
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
        )

        val nextDayPasses = listOf(
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
        )

        val app = GildedRose(dayZeroPasses)
        val agedItems = app.updateQuality()
        assertEquals(nextDayPasses, agedItems)
    }
}