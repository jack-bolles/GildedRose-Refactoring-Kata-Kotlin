package com.gildedrose

typealias GildedRose = List<Item>

fun GildedRose.updateQuality() = this.map { i -> updateByType(i) }



