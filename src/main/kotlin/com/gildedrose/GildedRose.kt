package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.indices.forEach { i ->
            val item = items[i]
            val name = item.name
            when (name) {
                "Aged Brie" -> {
                    `better with age`(item)
                }
                "Backstage passes to a TAFKAL80ETC concert" -> {
                    `better with age`(item)
                    if (item.sellIn < 11) {
                        `better with age`(item)
                    }

                    if (item.sellIn < 6) {
                        `better with age`(item)
                    }
                }
                "Sulfuras, Hand of Ragnaros" -> { //do nothing
                }
                else ->
                    `worse with age`(item)
            }

            when (name) {
                "Sulfuras, Hand of Ragnaros" -> {
                }
                else -> {
                    item.sellIn = item.sellIn - 1
                }
            }

            if (item.sellIn < 0) {
                when (name) {
                    "Backstage passes to a TAFKAL80ETC concert" -> {
                        item.quality = item.quality - item.quality
                    }
                    "Sulfuras, Hand of Ragnaros" -> {
                    }
                    "Aged Brie" -> {
                        `better with age`(item)
                    }
                }
            }
        }
    }

    private fun `worse with age`(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
    }

    private fun `better with age`(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
    }

}

