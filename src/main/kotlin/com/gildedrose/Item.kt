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

    val quality = calculateQuality(item, daysOut)

    return item.copy(
        sellIn = sellIn,
        quality = quality
    )
}

private fun calculateQuality(item: Item, daysOut: Int): Int {
    return when {
        item.name == "Backstage passes to a TAFKAL80ETC concert" -> determineQuality(
            item.quality, incrementQuality(item, daysOut)
        )

        item.name == "Sulfuras, Hand of Ragnaros" -> item.quality
        item.name == "Aged Brie" -> determineQuality(item.quality, daysOut)
        item.name.startsWith("Conjured") -> determineQuality(item.quality, -2 * daysOut)
        else -> determineQuality(item.quality, -1 * daysOut)
    }
}

private fun incrementQuality(item: Item, daysOut: Int): Int {
    val daysToSell = item.sellIn
    var totalIncrement = 0
    (1 until daysOut + 1).forEach { i ->
        totalIncrement += increment(daysToSell - i, item)
    }
    return totalIncrement
}

private fun increment(sellIn: Int, item: Item): Int {
    return if (sellIn < 0) -item.quality
    else if (sellIn <= 5) 3
    else if (sellIn <= 10) 2
    else 1
}

private fun determineQuality(initialQuality: Int, amountToAge: Int, hasMax: Boolean = true): Int {
    var quality = initialQuality + amountToAge
    quality = Integer.max(0, quality)
    if (hasMax) quality = Integer.min(50, quality)

    return quality
}
