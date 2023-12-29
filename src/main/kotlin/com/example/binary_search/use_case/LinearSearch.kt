package com.example.binary_search.use_case

object LinearSearch {

    fun execute(searchElement: Long, elements: List<Long>): Long {
        var count = 0L
        var elementWasFound = false

        for (element in elements) {
            count++
            if (element == searchElement) {
                elementWasFound = true
                break
            }
        }

        if (elementWasFound)
            println("We found the element after $count iterations")
        else
            println("$count iterations were performed but we didn't found the element in the list")

        return count
    }
}
