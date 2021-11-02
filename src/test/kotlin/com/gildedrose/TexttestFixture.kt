package com.gildedrose

fun main(args: Array<String>) {
    updateQualityOf(gigo)
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

fun updateQualityOf(arrayOfItems: List<Item>) {
    var dayCount = 0
    val app = GildedRose(arrayOfItems)

    var actual = `report days stock`(dayCount, arrayOfItems)
    if (gigoDayZero == actual) println("day Zero as expected")

    app.updateQuality()
    actual = `report days stock`(++dayCount, arrayOfItems)
    if (gigoDayOne == actual) println("day One as expected")
    else {
        println(gigoDayOne)
        println(actual)
    }
}

private fun `report days stock`(dayCount: Int, items: List<Item>): String {
    return "-------- day $dayCount --------" + "\n" +
            "name, sellIn, quality" + "\n" +
            items.joinToString("\n")
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
Conjured Mana Cake, 2, 5"""
            .trimIndent()
    }

