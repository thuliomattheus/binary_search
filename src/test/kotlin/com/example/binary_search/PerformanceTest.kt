package com.example.binary_search

import com.example.binary_search.use_case.LinearSearch
import com.example.binary_search.use_case.OptimizedBinarySearch
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.Instant
import kotlin.math.pow

class PerformanceTest {

    @Test
    fun test() {
        for (i in 0..22) {
            System.err.println("Searching for element ${2.0.pow(i).toLong()}")
            searchElementOnListUsingOptimizedBinarySearch(2.0.pow(i).toLong(), 1, 2.0.pow(22).toLong())
            searchElementOnListUsingLinearSearch(2.0.pow(i).toLong(), 1, 2.0.pow(22).toLong())
        }
    }

    private fun searchElementOnListUsingOptimizedBinarySearch(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
    ) {
        val start = Instant.now()
        OptimizedBinarySearch.execute(
            searchElement,
            (starterElement..finalElement).toList()
        ).also {
            System.err.println("Element found after $it iterations at ${Duration.between(start, Instant.now()).nano} nanoseconds using optimized binary search\n")
        }
    }

    private fun searchElementOnListUsingLinearSearch(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
    ) {
        val start = Instant.now()
        LinearSearch.execute(
            searchElement,
            (starterElement..finalElement).toList()
        ).also {
            System.err.println("Element found after $it iterations at ${Duration.between(start, Instant.now()).nano} nanoseconds using linear search\n")
        }
    }
}
