package com.gildedrose

data class Item(val name: String, val sellIn: Int, val quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

//this begs some typing, but at this point we only know that certain behaviours are keyed off of specific string values
fun age(item: Item): Item {
    return if (item.name == "Aged Brie") {
        ageBrie(item)
    } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
        agePass(item)
    } else if (item.name == "Sulfuras, Hand of Ragnaros") {
        ageLegend(item)
    } else if (item.name.startsWith("Conjured")) {
        ageConjured(item)
    } else ageGeneric(item)
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

fun ageConjured(item: Item): Item {
    return item.copy(
        sellIn = item.sellIn - 1,
        quality = determineQuality(item, -2)
    )
}

private fun ageGeneric(item: Item): Item {
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
