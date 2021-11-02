package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ItemTest {
    @Test
    fun `quality cant exceed 50`() {
        val dayZeroPasses = arrayOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
            Item("Aged Brie", 2, 50),
        )

        val nextDayPasses = arrayOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
            Item("Aged Brie", 1, 50),
        )

        val app = GildedRose(dayZeroPasses)
        app.updateQuality()
        Assertions.assertEquals(nextDayPasses[0], app.items[0])
        Assertions.assertEquals(nextDayPasses[1], app.items[1])
    }
}