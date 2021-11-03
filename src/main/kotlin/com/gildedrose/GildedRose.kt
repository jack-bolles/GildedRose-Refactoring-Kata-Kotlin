package com.gildedrose

typealias GildedRose = List<Item>

fun GildedRose.ageStock() = this.map { i -> age(i) }

fun main(args: Array<String>) {
    val (today, tomorrow) = runReportOnTomorrowsStock(args.map { parseToItem(it) })
    println(today)
    println(tomorrow)
}

internal fun parseToItem(parseMe: String): Item {
    val params = parseMe.split(",")
    return Item(
        name = params[0].trim(),
        sellIn = params[1].trim().toInt(),
        quality = params[2].trim().toInt()
    )
}

fun runReportOnTomorrowsStock(items: List<Item>): Pair<String, String> {
    var dayCount = 0
    val zeroDayReport = `report days stock`(dayCount, items)
    val nextDayReport = `report days stock`(++dayCount, items.ageStock())
    return Pair(zeroDayReport, nextDayReport)
}

private fun `report days stock`(dayCount: Int, items: List<Item>): String {
    return "-------- day $dayCount --------" + "\n" +
            "name, sellIn, quality" + "\n" +
            items.joinToString("\n")
}




