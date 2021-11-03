package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AgingReportTest {
    @Test
    fun `report _end_of_week updates all correctly`() {
        //0...4 e.g. running on Monday for Friday's status
        assertEquals(gigoDayZero, stockReportFor(gigo, 0))
        assertEquals(gigoDayFive, stockReportFor(gigo.ageFor(4), 4))
    }

    @Test
    fun `report next day updates all correctly`() {
        assertEquals(gigoDayZero, stockReportFor(gigo, 0))
        assertEquals(gigoDayOne, stockReportFor(gigo.ageFor(1), 1))
    }

    @Test
    fun `parseToItem works as expected`() {
        assertEquals(parseToItem("+5 Dexterity Vest, 10, 20"), Item("+5 Dexterity Vest", 10, 20))
    }

    private val gigo: List<Item>
        get() {
            return listOf(
                Item("+5 Dexterity Vest", 10, 20),
                Item("Aged Brie", 2, 0),
                Item("Elixir of the Mongoose", 5, 7),
                Item("Sulfuras, Hand of Ragnaros", 0, 80),
                Item("Sulfuras, Hand of Ragnaros", -1, 80),
                Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                Item("Conjured Mana Cake", 3, 6)
            )
        }

    private val gigoDayZero: String
        get() {
            return """-------- day 0 --------
name, sellIn, quality
+5 Dexterity Vest, 10, 20
Aged Brie, 2, 0
Elixir of the Mongoose, 5, 7
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 15, 20
Backstage passes to a TAFKAL80ETC concert, 10, 49
Backstage passes to a TAFKAL80ETC concert, 5, 49
Conjured Mana Cake, 3, 6"""
                .trimIndent()
        }

    private val gigoDayOne: String
        get() {
            return """-------- day 1 --------
name, sellIn, quality
+5 Dexterity Vest, 9, 19
Aged Brie, 1, 1
Elixir of the Mongoose, 4, 6
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 14, 21
Backstage passes to a TAFKAL80ETC concert, 9, 50
Backstage passes to a TAFKAL80ETC concert, 4, 50
Conjured Mana Cake, 2, 4"""
                .trimIndent()
        }

    private val gigoDayFive: String
        get() {
            return """-------- day 4 --------
name, sellIn, quality
+5 Dexterity Vest, 6, 16
Aged Brie, -2, 4
Elixir of the Mongoose, 1, 3
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 11, 24
Backstage passes to a TAFKAL80ETC concert, 6, 50
Backstage passes to a TAFKAL80ETC concert, 1, 50
Conjured Mana Cake, -1, 0"""
        }

    @Test
    @Disabled("convenience to generate 'expected' reports")
    fun generateFiveDays() {
        var todaysItems = gigo
        for (i in 0..4) {
            println(stockReportFor(todaysItems, i))
            todaysItems = todaysItems.ageFor(1)
        }
        assertEquals(true, true)
    }
}
