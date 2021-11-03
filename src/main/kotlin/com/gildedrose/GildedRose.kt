package com.gildedrose

typealias GildedRose = List<Item>

fun GildedRose.ageStock() = this.map { i -> age(i) }

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

fun stockReportFor(items: List<Item>, daysOut: Int): String {
    return formatHeader(daysOut) + "\n" +
            formatStock(items)
}

private fun formatStock(items: List<Item>) = items.joinToString("\n")

private fun formatHeader(dayCount: Int) = "-------- day $dayCount --------" +
        "\n" + "name, sellIn, quality"




