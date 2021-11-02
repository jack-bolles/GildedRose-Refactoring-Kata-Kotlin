package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `passes quality falls to zero after the concert`() {
        val dayZeroPasses = arrayOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
        )

        val nextDayPasses = arrayOf(
            Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
        )

        val app = GildedRose(dayZeroPasses)
        app.updateQuality()
        assertEquals(nextDayPasses[0], app.items[0])
    }

    @Test
    fun `passes quality increases by 2 when there are 10 days or less`() {
        val dayZeroPasses = arrayOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 12, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 11, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 30),
        )

        val nextDayPasses = arrayOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 11, 29),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 32),
            Item("Backstage passes to a TAFKAL80ETC concert", 9, 32),
        )

        val app = GildedRose(dayZeroPasses)
        app.updateQuality()
        assertEquals(nextDayPasses[0], app.items[0])
        assertEquals(nextDayPasses[1], app.items[1])
        assertEquals(nextDayPasses[2], app.items[2])
    }

    @Test
    fun `passes quality increases by 3 when there are 5 days or less `() {
        val dayZeroPasses = arrayOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 30),
        )

        val nextDayPasses = arrayOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 32),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 33),
            Item("Backstage passes to a TAFKAL80ETC concert", 3, 33),
        )

        val app = GildedRose(dayZeroPasses)
        app.updateQuality()
        assertEquals(nextDayPasses[0], app.items[0])
        assertEquals(nextDayPasses[1], app.items[1])
        assertEquals(nextDayPasses[2], app.items[2])
    }

    @Test
    fun `quality cant exceed 50`() {
        val dayZeroPasses = arrayOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
        )

        val nextDayPasses = arrayOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
        )

        val app = GildedRose(dayZeroPasses)
        app.updateQuality()
        assertEquals(nextDayPasses[0], app.items[0])
    }

}
