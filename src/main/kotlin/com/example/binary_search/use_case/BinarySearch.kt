package com.example.binary_search.use_case

import kotlin.math.abs
import kotlin.math.log

object BinarySearch {

    fun execute(searchElement: Long, elements: List<Long>): Long {
        var count = 0L
        var currentElements = elements
        var elementWasFound = false

         do {
            count++

            println("\nVerifying if the element at half position on list it's $searchElement")
            val middleElement = getElementAtHalfPosition(currentElements, searchElement)

            if (middleElement == searchElement) {
                elementWasFound = true
                break
            }
            currentElements = splitListByHalf(searchElement, middleElement, currentElements)
        } while (count < log(elements.size.toDouble(), 2.0))

        if(elementWasFound)
            println("We found the element after $count iterations")
        else
            println("$count iterations were performed but we didn't found the element in the list")

        return count
    }

    private fun splitListByHalf(n: Long, middleElement: Long, elements: List<Long>): List<Long> {
        println("Splitting list [${elements.first()} - ${elements.last()}] of ${elements.size} elements, to fetch the element $n")
        val halfPosition = elements.size/2

        return if (middleElement > n) {
            (
                if (elements.size % 2 == 0)
                    elements.subList(0, halfPosition)
                else
                    elements.subList(0, halfPosition + 1)
            )
                .also {
                    println("Seeking smaller side of the last list. [${it.first()} - ${it.last()}]")
                }
        } else {
            elements.subList(halfPosition, elements.size)
                .also {
                    println("Seeking bigger side of the last list. [${it.first()} - ${it.last()}]")
                }
        }
    }

    private fun getElementAtHalfPosition(elements: List<Long>, expectedValue: Long) =
        (elements.size/2).let { halfPosition ->
            (
                if (elements.size % 2 != 0)
                    elements[halfPosition]
                else if (abs(elements[halfPosition] - expectedValue) < abs(elements[halfPosition - 1] - expectedValue))
                    elements[halfPosition]
                else
                    elements[halfPosition - 1]
            )
                .also {
                    println("Element at half position = $it")
                }
        }
}
