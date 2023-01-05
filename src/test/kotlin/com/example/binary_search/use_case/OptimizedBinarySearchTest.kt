package com.example.binary_search.use_case

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OptimizedBinarySearchTest {

    @ParameterizedTest
    @CsvSource(textBlock =
        """# searchElement, starterElement, finalElement, expectedIterations
                    1,              1,            1,              1
                    2,              1,            3,              1
                    3,              1,            5,              1
                    4,              1,            7,              1
                    5,              1,            9,              1
                    13,             1,            25,             1
                    19,             1,            37,             1
                   436,             1,            871,            1
                   1_234,           1,           2_468,           1
                  100_000,          1,          200_000,          1
                 5_000_000,         1,         10_000_000,        1 """
    )
    fun `should find element in half position in an odd list with only one iteration`(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
        expectedIterations: Long,
    ) = searchElementOnList(
        starterElement = starterElement,
        searchElement = searchElement,
        finalElement = finalElement,
        expectedIterations = expectedIterations,
    )

    @ParameterizedTest
    @CsvSource(textBlock =
        """# searchElement, starterElement, finalElement, expectedIterations
                    1,              1,            2,              1,
                    2,              1,            2,              1,
                    2,              1,            4,              1,
                    3,              1,            4,              1,
                    3,              1,            6,              1,
                    4,              1,            6,              1,
                    4,              1,            8,              1,
                    5,              1,            8,              1,
                    5,              1,            10,             1,
                    6,              1,            10,             1,
                    33,             1,            66,             1,
                    34,             1,            66,             1,
                    49,             1,            98,             1,
                    50,             1,            98,             1,
                  5_000,            1,          10_000,           1,
                  5_001,            1,          10_000,           1 """
    )
    fun `should find element in half position in an even list with only one iteration`(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
        expectedIterations: Long,
    ) = searchElementOnList(
            starterElement = starterElement,
            searchElement = searchElement,
            finalElement = finalElement,
            expectedIterations = expectedIterations,
    )

    @ParameterizedTest
    @CsvSource(textBlock =
    """# searchElement, starterElement, finalElement, expectedIterations
                    1,              1,            3,              2,
                    3,              1,            3,              2,
                    2,              1,            5,              2,
                    4,              1,            5,              2,
                    2,              1,            7,              2,
                    3,              1,            7,              2,
                    5,              1,            7,              2,
                    6,              1,            7,              2 """
    )
    fun `should find element in an odd list with two iterations`(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
        expectedIterations: Long,
    ) = searchElementOnList(
        starterElement = starterElement,
        searchElement = searchElement,
        finalElement = finalElement,
        expectedIterations = expectedIterations,
    )

    @ParameterizedTest
    @CsvSource(textBlock =
        """# searchElement, starterElement, finalElement, expectedIterations
                    1,              1,            4,              2,
                    4,              1,            4,              2,
                    2,              1,            6,              2,
                    5,              1,            6,              2,
                    2,              1,            8,              2,
                    3,              1,            8,              2,
                    6,              1,            8,              2,
                    7,              1,            8,              2 """
    )
    fun `should find element in an even list with two iterations`(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
        expectedIterations: Long,
    ) = searchElementOnList(
        starterElement = starterElement,
        searchElement = searchElement,
        finalElement = finalElement,
        expectedIterations = expectedIterations,
    )

    @ParameterizedTest
    @CsvSource(textBlock =
        """# searchElement, starterElement, finalElement, expectedIterations
                    1,              1,            8,              3,
                    8,              1,            8,              3,
                    1,              1,            13,             4,
                    13,             1,            13,             4,
                    1,              1,            16,             4,
                    16,             1,            16,             4,
                    1,              1,            64,             6,
                    64,             1,            64,             6,
                    19,             19,          1_000,           10,
                  1_000,            1,           1_000,           10,
                    10,             10,          1_024,           10,
                  1_024,            1,           1_024,           10,
                   102,            102,         500_000,          19,
                 500_000,           1,          500_000,          19,
                    1,              1,         1_000_000,         20,
                1_000_000,         187,        1_000_000,         20 """
    )
    fun `should find element in an odd list with at most log2(n) iterations`(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
        expectedIterations: Long,
    ) = searchElementOnList(
        starterElement = starterElement,
        searchElement = searchElement,
        finalElement = finalElement,
        expectedIterations = expectedIterations,
    )

    @ParameterizedTest
    @CsvSource(textBlock =
        """# searchElement, starterElement, finalElement, expectedIterations
                    1,              1,            7,              3,
                    7,              1,            7,              3,
                    1,              1,            13,             4,
                    13,             1,            13,             4,
                    1,              1,            15,             4,
                    15,             1,            15,             4,
                    1,              1,            63,             6,
                    63,             1,            63,             6,
                    19,             19,          1_001,           10,
                  1_001,            57,          1_001,           10,
                    10,             10,          1_023,           10,
                  1_023,            1,           1_023,           10,
                   102,            102,         500_001,          19,
                 500_001,         2_000,        500_001,          19,
                    1,              1,         1_000_001,         20,
                1_000_001,         187,        1_000_001,         20 """
    )
    fun `should find element in an even list with at most log2(n) iterations`(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
        expectedIterations: Long,
    ) = searchElementOnList(
        starterElement = starterElement,
        searchElement = searchElement,
        finalElement = finalElement,
        expectedIterations = expectedIterations,
    )

    private fun searchElementOnList(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
        expectedIterations: Long
    ) {
        assertEquals(
            expectedIterations,
            OptimizedBinarySearch.execute(
                searchElement,
                (starterElement..finalElement).toList()
            ),
        )
    }
}
