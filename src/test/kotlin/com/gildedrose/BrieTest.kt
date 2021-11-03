package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BrieTest {

    @Test
    fun `brie quality doubles after sell by`() {
        val dayZero = listOf(
            Item("Aged Brie", 2, 0),
            Item("Aged Brie", 1, 0),
            Item("Aged Brie", 0, 0),
        )

        val nextDay = listOf(
            Item("Aged Brie", 1, 1),
            Item("Aged Brie", 0, 1),
            Item("Aged Brie", -1, 1),
        )

        assertEquals(nextDay, dayZero.ageFor(1))
    }
}
