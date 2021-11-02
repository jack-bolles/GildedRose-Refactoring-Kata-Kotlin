package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `passes age to zero after the concert`() {
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

    //Quality increases by 2 when there are 10 days or less and
    // by 3 when there are 5 days or less but


}
