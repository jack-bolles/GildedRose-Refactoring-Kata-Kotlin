package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ItemTest {
    @Test
    fun `quality cant exceed 50`() {
        val dayZeroPasses = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
            Item("Aged Brie", 2, 50),
        )

        val nextDayPasses = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
            Item("Aged Brie", 1, 50),
        )

        val app = GildedRose(dayZeroPasses)
        val agedItems = app.updateQuality()
        Assertions.assertEquals(nextDayPasses, agedItems)
    }
}