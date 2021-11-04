package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ItemTest {
    @Test
    fun `items age for the correct amount of cycles`() {
        val dayZeroItems = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 33),
            Item("Aged Brie", 2, 30),
            Item("Conjured Mana Cake", 1, 2),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Elixir of the Mongoose", 5, 7),
        )
        val dayFourItems = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 45),
            Item("Aged Brie", -2, 34),
            Item("Conjured Mana Cake", -3, 0),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Elixir of the Mongoose", 1, 3),
        )

        Assertions.assertEquals(dayFourItems, dayZeroItems.ageFor(4))
    }

    @Test
    fun `quality cant exceed 50`() {
        val dayZero = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
            Item("Aged Brie", 2, 50),
        )

        val nextDay = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
            Item("Aged Brie", 1, 50),
        )

        Assertions.assertEquals(nextDay, dayZero.ageFor(1))
    }

    @Test
    fun `conjured items degrade twice as fast`() {
        val dayZero = listOf(
            Item("Conjured Mana Cake", 2, 4),
            Item("Conjured Mana Cake", 1, 2),
            Item("Conjured Mana Cake", 0, 0),
        )

        val nextDay = listOf(
            Item("Conjured Mana Cake", 1, 2),
            Item("Conjured Mana Cake", 0, 0),
            Item("Conjured Mana Cake", -1, 0),
        )

        Assertions.assertEquals(nextDay, dayZero.ageFor(1))
    }
}