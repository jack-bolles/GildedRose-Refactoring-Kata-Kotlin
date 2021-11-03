package com.gildedrose

data class Item(val name: String, val sellIn: Int, val quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

fun age(item: Item, daysOut: Int): Item {
    val sellIn = when (item.name) {
        "Sulfuras, Hand of Ragnaros" -> item.sellIn
        else -> item.sellIn - daysOut
    }

    val quality = calculateQuality(item, daysOut, sellIn)

    return item.copy(
        sellIn = sellIn,
        quality = quality
    )
}

private fun calculateQuality(item: Item, daysOut: Int, sellIn: Int) = when {
    item.name == "Backstage passes to a TAFKAL80ETC concert" -> determineQuality(
        item.quality, when {
            sellIn < 0 -> -item.quality
            sellIn <= 5 -> 3
            sellIn <= 10 -> 2
            else -> 1
        }
    )

    item.name == "Sulfuras, Hand of Ragnaros" -> item.quality

    item.name == "Aged Brie" -> determineQuality(item.quality, daysOut)
    item.name.startsWith("Conjured") -> determineQuality(item.quality, -2 * daysOut)
    else -> determineQuality(item.quality, -1 * daysOut)
}

private fun determineQuality(initialQuality: Int, amountToAge: Int, hasMax: Boolean = true): Int {
    var quality = initialQuality + amountToAge
    quality = Integer.max(0, quality)
    if (hasMax) quality = Integer.min(50, quality)

    return quality
}
