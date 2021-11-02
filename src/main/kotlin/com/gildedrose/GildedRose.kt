package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.indices.forEach { i ->
            val item = items[i]
            when (item.name) {
                "Aged Brie" -> {
                    updateBrie(item)
                }
                "Backstage passes to a TAFKAL80ETC concert" -> {
                    updatePass(item)
                }
                "Sulfuras, Hand of Ragnaros" -> {
                    updateLegend(item)
                }
                else ->
                    update(item)
            }
        }
    }

    private fun updateBrie(item: Item) {
        betterWithAge(item)
        item.sellIn = item.sellIn - 1
        if (item.sellIn < 0) {
            betterWithAge(item)
        }
    }

    private fun updatePass(item: Item) {
        //Quality increases by 2 when there are 10 days or less and
        // by 3 when there are 5 days or less but
        //Quality drops to 0 after the concert
        betterWithAge(item)
        if (item.sellIn <= 10) {
            betterWithAge(item)
        }
        if (item.sellIn <= 5) {
            betterWithAge(item)
        }

        item.sellIn = item.sellIn - 1

        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality
        }
    }

    private fun updateLegend(item: Item) { /*do nothing */
    }

    private fun update(item: Item) {
        worseWithAge(item)

        //tbc - can this be negative? what does that mean ??
        item.sellIn = item.sellIn - 1

    }

    private fun worseWithAge(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
    }

    private fun betterWithAge(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
    }

}

