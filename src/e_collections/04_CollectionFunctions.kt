package e_collections

// The filter function works in the same way as a lot of languages
// Takes a lambda predicate returning a boolean to filter the items of a collect
val numbers = listOf(1, -2, 3, -4, 5, -6)
val words = listOf("Lets", "find", "something", "in", "collection", "somehow")

val positives = numbers.filter { x -> x > 0 }

// Can use "it" shorthand to avoid assignment on single parameter lambdas
// Using the shorthand for all below examples where I can
val negatives = numbers.filter { it < 0 }

// The "map" (not to be confused with the Map type) is the same as map / select in other languages
val doubled = numbers.map { it * 3 }

// "any" returns true if at least 1 element matches the predicate
val anyNegativeNumbers = numbers.any { it < 0 }

// "all" returns true if all elements match the predicate
val allEvenNumbers = numbers.all { it % 2 == 0}

// "none" returns true if no elements match the predicate
val allUnderTen = numbers.none { it >= 10 }

// "find" and "findLast" return the first item in a collection matching a condition
// If nothing matched, returns null
val firstFound = words.find { it.startsWith("some") } // Returns "something"
val lastFound = words.findLast { it.startsWith("some") } // Returns "somehow"

// "first" and "last" returns the first or last items in the collection
// Either without a predicate, or with a predicate filtering the items
// Throws an error if none can be found
val first = numbers.first()
val last = numbers.last{ it > 3 }

// Can use "firstOrNull" and "lastOrNull" to do the same, but return null if none are found matching
val lastIfMatched = numbers.lastOrNull{ it > 10 }

// "count" returns the total items in a collection, or that match a predicate
val totalCount = numbers.count()
val evenCount = numbers.count { it % 2 == 0 }

