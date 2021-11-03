package com.gildedrose

typealias GildedRose = List<Item>

fun GildedRose.ageStock() = this.map { i -> age(i) }



