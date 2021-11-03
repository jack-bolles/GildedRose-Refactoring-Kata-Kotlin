package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BackPagePassesTest {

    @Test
    fun `passes quality falls to zero after the concert`() {
        val dayZeroPasses = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 1, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
        )

        val nextDay = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 33),
            Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
        )

        assertEquals(nextDay, dayZeroPasses.ageFor(1))
    }

    @Test
    fun `passes quality increases by 2 when there are 10 days or less`() {
        val dayZero = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 12, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 11, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 30),
        )

        val nextDay = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 11, 31),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 32),
            Item("Backstage passes to a TAFKAL80ETC concert", 9, 32),
        )

        assertEquals(nextDay, dayZero.ageFor(1))
    }

    @Test
    fun `passes quality increases by 3 when there are 5 days or less `() {
        val dayZero = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 7, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 30),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
        )

        val nextDay = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 32),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 33),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 33),
        )

        assertEquals(nextDay, dayZero.ageFor(1))
    }
}
