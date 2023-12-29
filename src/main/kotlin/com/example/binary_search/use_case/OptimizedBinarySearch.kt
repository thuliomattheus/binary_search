package com.example.binary_search.use_case

object OptimizedBinarySearch {

    fun execute(searchElement: Long, elements: List<Long>): Long {
        var count = 0L
        var elementWasFound = false
        var firstIndex: Int = elements.first().toInt()
        var lastIndex: Int = elements.last().toInt()

        do {
            count++
            val midIndex = ((firstIndex + lastIndex) / 2)

            if (elements[midIndex] == searchElement) {
                elementWasFound = true
                break
            } else if(elements[midIndex] < searchElement) {
                firstIndex = midIndex + 1
            } else {
                lastIndex = midIndex - 1
            }
        } while (firstIndex <= lastIndex)

        if(elementWasFound)
            println("We found the element after $count iterations")
        else
            println("$count iterations were performed but we didn't found the element in the list")

        return count
    }
}
