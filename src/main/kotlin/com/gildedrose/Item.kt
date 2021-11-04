package com.gildedrose

data class Item(val name: String, val sellIn: Int, val quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

fun Item.ageBy(days: Int): Item {
    return copy(
        sellIn = remainingSellInAfter(days),
        quality = qualityIn(days)
    )
}

private fun Item.remainingSellInAfter(days: Int): Int {
    return when (name) {
        "Sulfuras, Hand of Ragnaros" -> sellIn
        else -> sellIn - days
    }
}

private fun Item.qualityIn(days: Int): Int {
    return when {
        name == "Backstage passes to a TAFKAL80ETC concert" ->
            boundedQuality(quality + this.incrementQualityFor(days))
        name == "Sulfuras, Hand of Ragnaros" ->
            quality
        name == "Aged Brie" ->
            boundedQuality(quality + days)
        name.startsWith("Conjured") ->
            boundedQuality(quality + -2 * days)
        else -> boundedQuality(quality + -1 * days)
    }
}

private fun boundedQuality(rawQuality: Int): Int {
    return Integer.min(50, Integer.max(0, rawQuality))
}

private fun Item.incrementQualityFor(days: Int): Int {
    val daysToSell = sellIn
    return (1 until days + 1)
        .fold(0) { total, e -> total + accelerateQualityWhenExpiring(daysToSell - e, quality) }
}

private fun accelerateQualityWhenExpiring(sellIn: Int, startingQuality: Int): Int {
    return when {
        sellIn < 0 -> -startingQuality
        sellIn <= 5 -> 3
        sellIn <= 10 -> 2
        else -> 1
    }
}
