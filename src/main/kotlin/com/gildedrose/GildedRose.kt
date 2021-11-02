package com.gildedrose

import java.lang.Integer.max
import java.lang.Integer.min

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
        item.sellIn = item.sellIn - 1

        when {
            item.sellIn < 0 -> {
                age(item, 2)
            }
            else -> {
                age(item, 1)
            }
        }
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

    private fun age(item: Item, amountToAge: Int) {
        val quality = min(50, item.quality + amountToAge)
        item.quality = min(50, quality)
        item.quality = max(0, quality)
    }

}

