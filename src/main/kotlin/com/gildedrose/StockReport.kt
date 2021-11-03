package com.gildedrose

fun stockReportFor(items: List<Item>, daysOut: Int): String {
    return formatHeader(daysOut) + "\n" +
            formatStock(items)
}

private fun formatStock(items: List<Item>) = items.joinToString("\n")

private fun formatHeader(dayCount: Int) = "-------- day $dayCount --------" +
        "\n" + "name, sellIn, quality"
