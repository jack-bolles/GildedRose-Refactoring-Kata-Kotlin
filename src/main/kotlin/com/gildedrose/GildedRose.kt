package com.gildedrose

typealias GildedRose = List<Item>

fun main(args: Array<String>) {
    val items = args.map { parseToItem(it) }
    println(stockReportFor(items, 0))
    println(stockReportFor(items.ageFor(1), 1))
}

internal fun parseToItem(parseMe: String): Item {
    val params = parseMe.split(",")
    return Item(
        name = params[0].trim(),
        sellIn = params[1].trim().toInt(),
        quality = params[2].trim().toInt()
    )
}

fun GildedRose.ageFor(daysOut: Int): List<Item> {
    if (daysOut != 1) throw NotImplementedError("multiple days still to come")
    return this.map { age(it, daysOut) }
}



