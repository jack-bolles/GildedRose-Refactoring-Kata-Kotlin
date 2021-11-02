package com.gildedrose

import java.lang.Integer.max
import java.lang.Integer.min

class GildedRose(val items: List<Item>) {

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
                else -> update(item)
            }
        }
    }

    private fun updateBrie(item: Item) {
        item.sellIn = item.sellIn - 1

        var qualityAdjustment: Int
        when {
            item.sellIn < 0 -> 2
            else -> 1
        }.also { qualityAdjustment = it }

        age(item, qualityAdjustment, hasMin = false)
    }

    private fun updatePass(item: Item) {
        item.sellIn = item.sellIn - 1

        var qualityAdjustment: Int
        when {
            item.sellIn < 0 -> -item.quality
            item.sellIn <= 5 -> 3
            item.sellIn <= 10 -> 2
            else -> 1
        }.also { qualityAdjustment = it }

        age(item, qualityAdjustment)
    }

    private fun updateLegend(item: Item) { /*do nothing */
    }

    private fun update(item: Item) {
        //tbc - can this be negative? what does that mean ??
        item.sellIn = item.sellIn - 1
        age(item, -1)
    }

    private fun age(item: Item, amountToAge: Int, hasMin: Boolean = true, hasMax: Boolean = true) {
        val quality = min(50, item.quality + amountToAge)
        if (hasMax) item.quality = min(50, quality)
        if (hasMin) item.quality = max(0, quality)
    }

}

