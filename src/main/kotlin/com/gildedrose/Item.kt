package com.gildedrose

data class Item(val name: String, val sellIn: Int, val quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

fun updateByType(item: Item): Item {
    return when (item.name) {
        "Aged Brie" -> {
            updateBrie(item)
        }
        "Backstage passes to a TAFKAL80ETC concert" -> {
            updatePass(item)
        }
        "Sulfuras, Hand of Ragnaros" -> {
            updateLegend(item)
        }
        else -> update(item)
    }
}

private fun updateBrie(item: Item): Item {
    return item.copy(
        sellIn = item.sellIn - 1,
        quality = determineQuality(item, 1)
    )
}

private fun updatePass(item: Item): Item {
    val sellIn = item.sellIn - 1

    val qualityAdjustment: Int = when {
        sellIn < 0 -> -item.quality
        sellIn <= 5 -> 3
        sellIn <= 10 -> 2
        else -> 1
    }

    val quality = determineQuality(item, qualityAdjustment)
    return item.copy(
        sellIn = sellIn,
        quality = quality
    )
}

private fun updateLegend(item: Item): Item { /*do nothing */
    return item
}

private fun update(item: Item): Item {
    //tbc - can this be negative? what does that mean ??
    return item.copy(
        sellIn = item.sellIn - 1,
        quality = determineQuality(item, -1)
    )
}

private fun determineQuality(item: Item, amountToAge: Int, hasMax: Boolean = true): Int {
    var quality = item.quality + amountToAge
    quality = Integer.max(0, quality)
    if (hasMax) quality = Integer.min(50, quality)

    return quality
}
