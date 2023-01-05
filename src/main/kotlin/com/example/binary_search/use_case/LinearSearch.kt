package com.example.binary_search.use_case

class LinearSearch {

    companion object {

        fun execute(searchElement: Long, elements: List<Long>, startFromEnd: Boolean = false): Long {
            var count = 0L
            var elementWasFound = false

            for (element in
                if(startFromEnd) elements.reversed()
                else elements
            ) {
                count++
                if (element == searchElement) {
                    elementWasFound = true
                    break
                }
            }

            if(elementWasFound)
                println("We found the element after $count iterations")
            else
                println("$count iterations were performed but we didn't found the element in the list")

            return count
        }
    }
}
