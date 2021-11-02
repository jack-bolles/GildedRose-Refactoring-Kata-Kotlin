package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BackPagePassesTest {

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
    }

    @Test
    fun `passes quality falls to zero after the concert`() {
        val dayZeroPasses = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 1, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
        )

        val nextDayPasses = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 33),
            Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
        )

        val app = GildedRose(dayZeroPasses)
        app.updateQuality()
        assertEquals(nextDayPasses[0], app.items[0])
    }

    @Test
    fun `passes quality increases by 2 when there are 10 days or less`() {
        val dayZeroPasses = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 12, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 11, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 30),
        )

        val nextDayPasses = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 11, 31),
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
        val dayZeroPasses = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 7, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
        )

        val nextDayPasses = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 32),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 33),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 33),
        )

        val app = GildedRose(dayZeroPasses)
        app.updateQuality()
        assertEquals(nextDayPasses[0], app.items[0])
        assertEquals(nextDayPasses[1], app.items[1])
        assertEquals(nextDayPasses[2], app.items[2])
    }
}
