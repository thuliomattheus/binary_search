package com.example.binary_search.use_case

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LinearSearchTest {

    @ParameterizedTest
    @CsvSource(textBlock =
        """# searchElement, starterElement, finalElement, expectedIterations
                    1,              1,            1,              1
                    2,              1,            3,              2
                    3,              1,            5,              3
                    4,              1,            7,              4
                    5,              1,            9,              5
                    13,             1,            25,             13
                    19,             1,            37,             19
                   200,             1,            610,           200
                   436,             1,            871,           436
                   1_000,           1,           2_468,         1_000
                   1_234,           1,           2_468,         1_234
                  100_000,          1,          250_000,       100_000
                 5_000_000,         1,         10_800_000,    5_000_000 """
    )
    fun `should find elements at nth position starting from beginning of the list with n iterations`(
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
                    1,              1,            1,              1
                    2,              1,            3,              2
                    3,              1,            5,              3
                    4,              1,            7,              4
                    5,              1,            9,              5
                    13,             1,            25,             13
                    19,             1,            37,             19
                   200,             1,            610,           411
                   436,             1,            871,           436
                   1_000,           1,           2_468,         1_469
                   1_234,           1,           2_468,         1_235
                  100_000,          1,          250_000,       150_001
                 5_000_000,         1,         10_800_000,    5_800_001 """
    )
    fun `should find elements at nth position starting from end of the list with (size - n) iterations`(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
        expectedIterations: Long,
    ) = searchElementOnList(
        starterElement = starterElement,
        searchElement = searchElement,
        finalElement = finalElement,
        expectedIterations = expectedIterations,
        startFromEnd = true,
    )

    private fun searchElementOnList(
        searchElement: Long,
        starterElement: Long,
        finalElement: Long,
        expectedIterations: Long,
        startFromEnd: Boolean = false,
    ) {
        assertEquals(
            expectedIterations,
            LinearSearch.execute(
                searchElement,
                (starterElement..finalElement).toList(),
                startFromEnd,
            ),
        )
    }
}
