package com.gildedrose

typealias GildedRose = List<Item>

fun main(args: Array<String>) {
    val items = args.map { parseToItem(it) }
    println(stockReportFor(items, 0))
    println(stockReportFor(items.ageStock(), 1))
}

internal fun parseToItem(parseMe: String): Item {
    val params = parseMe.split(",")
    return Item(
        name = params[0].trim(),
        sellIn = params[1].trim().toInt(),
        quality = params[2].trim().toInt()
    )
}

fun GildedRose.ageStock() = this.map { i -> age(i) }

