package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ItemTest {
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

        Assertions.assertEquals(nextDayPasses, dayZeroPasses.ageStock())
    }

    @Test
    fun `conjured items degrade twice as fast`() {
        val dayZeroPasses = listOf(
            Item("Conjured Mana Cake", 2, 4),
            Item("Conjured Mana Cake", 1, 2),
            Item("Conjured Mana Cake", 0, 0),
        )

        val nextDayPasses = listOf(
            Item("Conjured Mana Cake", 1, 2),
            Item("Conjured Mana Cake", 0, 0),
            Item("Conjured Mana Cake", -1, 0),
        )

        Assertions.assertEquals(nextDayPasses, dayZeroPasses.ageStock())

    }
}