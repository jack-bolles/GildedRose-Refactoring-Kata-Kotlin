package com.gildedrose

import java.lang.Integer.max
import java.lang.Integer.min

class GildedRose(private val items: List<Item>) {

    fun updateQuality(): List<Item> {
        return items.map { i -> updateByType(i) }
    }

    private fun updateByType(item: Item): Item {
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

        val qualityAdjustment: Int = if (sellIn < 0) -item.quality
        else if (sellIn <= 5) 3
        else if (sellIn <= 10) 2
        else 1

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

    private fun determineQuality(item: Item, amountToAge: Int, hasMin: Boolean = true, hasMax: Boolean = true): Int {
        var quality = min(50, item.quality + amountToAge)
        if (hasMax) quality = min(50, quality)
        if (hasMin) quality = max(0, quality)

        return quality
    }

}

