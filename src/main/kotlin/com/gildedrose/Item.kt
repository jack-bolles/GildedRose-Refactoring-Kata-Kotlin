package com.gildedrose

data class Item(val name: String, val sellIn: Int, val quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

fun age(item: Item): Item {
    return when (item.name) {
        "Aged Brie" -> {
            ageBrie(item)
        }
        "Backstage passes to a TAFKAL80ETC concert" -> {
            agePass(item)
        }
        "Sulfuras, Hand of Ragnaros" -> {
            ageLegend(item)
        }
        else -> ageGeneric(item)
    }
}

private fun ageBrie(item: Item): Item {
    return item.copy(
        sellIn = item.sellIn - 1,
        quality = determineQuality(item, 1)
    )
}

private fun agePass(item: Item): Item {
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

private fun ageLegend(item: Item): Item { /*do nothing */
    return item
}

private fun ageGeneric(item: Item): Item {
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
