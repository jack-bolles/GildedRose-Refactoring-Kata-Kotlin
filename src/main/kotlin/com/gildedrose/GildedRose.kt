package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.indices.forEach { i ->
            val item = items[i]
            val name = item.name
            when (name) {
                "Aged Brie" -> if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
                "Backstage passes to a TAFKAL80ETC concert" -> if (item.quality < 50) {
                    item.quality = item.quality + 1

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                    }
                }
                "Sulfuras, Hand of Ragnaros" -> { //do nothing
                }
                else -> if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
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
                        if (item.quality < 50) {
                            item.quality = item.quality + 1
                        } else {
                            if (item.quality > 0) {
                                item.quality = item.quality - 1
                            }
                        }
                    }
                }
            }
        }
    }

}

