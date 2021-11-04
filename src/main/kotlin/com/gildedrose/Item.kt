package com.gildedrose

data class Item(val name: String, val sellIn: Int, val quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    object Pass {
        internal fun incrementQuality(item: Item, daysOut: Int): Int {
            val daysToSell = item.sellIn
            return (1 until daysOut + 1)
                .fold(0) { total, e -> total + increment(daysToSell - e, item.quality) }
        }

        private fun increment(sellIn: Int, startingQuality: Int): Int {
            return when {
                sellIn < 0 -> -startingQuality
                sellIn <= 5 -> 3
                sellIn <= 10 -> 2
                else -> 1
            }
        }
    }
}

fun age(item: Item, daysOut: Int): Item {
    return item.copy(
        sellIn = remainingDaysToSell(item, daysOut),
        quality = calculateQuality(item, daysOut)
    )
}

private fun remainingDaysToSell(item: Item, daysOut: Int): Int {
    return when (item.name) {
        "Sulfuras, Hand of Ragnaros" -> item.sellIn
        else -> item.sellIn - daysOut
    }
}

private fun calculateQuality(item: Item, daysOut: Int): Int {
    return when {
        item.name == "Backstage passes to a TAFKAL80ETC concert" ->
            boundedQuality(item.quality + Item.Pass.incrementQuality(item, daysOut))
        item.name == "Sulfuras, Hand of Ragnaros" ->
            item.quality
        item.name == "Aged Brie" ->
            boundedQuality(item.quality + daysOut)
        item.name.startsWith("Conjured") ->
            boundedQuality(item.quality + -2 * daysOut)
        else -> boundedQuality(item.quality + -1 * daysOut)
    }
}

private fun boundedQuality(rawQuality: Int): Int {
    return Integer.min(
        50,
        Integer.max(0, rawQuality)
    )
}
