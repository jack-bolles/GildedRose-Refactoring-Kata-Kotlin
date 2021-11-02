package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BrieTest {

    @Test
    fun `brie quality doubles after sell by`() {
        val dayZeroPasses = listOf(
            Item("Aged Brie", 2, 0),
            Item("Aged Brie", 1, 0),
            Item("Aged Brie", 0, 0),
        )

        val nextDayPasses = listOf(
            Item("Aged Brie", 1, 1),
            Item("Aged Brie", 0, 1),
            Item("Aged Brie", -1, 2),
        )

        val app = GildedRose(dayZeroPasses)
        app.updateQuality()
        assertEquals(nextDayPasses[0], app.items[0])
        assertEquals(nextDayPasses[1], app.items[1])
        assertEquals(nextDayPasses[2], app.items[2])
    }
}
