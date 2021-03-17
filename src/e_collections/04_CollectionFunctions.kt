package e_collections

fun main() {
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

    // "associateBy" and "groupBy" allow us to build a Map type out of a list of elements
    // "associateBy" selects the last matching element as the value for the key
    // "groupBy" selects all matching elements into a collection in the value under the key

    data class Person(val name: String, val city: String, val phone: String)

    val people = listOf(
        Person("Shania Twain", "Texas", "+447920444567"),
        Person("Steven Spielberg", "Montreal", "+133342413"),
        Person("Northlane", "Sydney", "+923432542552"),
        Person("Aaron Paul", "Montreal", "+33241314142425")
    )

    // Creates a Map<String, Person> with the phone number as the key
    val phoneBook = people.associateBy { it.phone }

    // Creates a Map<String, String> with the phone number as the key, the city as the value
    val cityBook = people.associateBy(Person::phone, Person::city)

    // Creates a Map<String, List<String>> with the city as the key
    // and a list of names of those in the city as the value
    val peopleCities = people.groupBy(Person::city, Person::name)

    // Creates a Map<String, String> with the city as the key
    // and the last matching name in the city as the value
    val lastPersonInCity = people.associateBy(Person::city, Person::name)

    // "partition" splits a single collection into 2 lists
    // The first list contains all items that match the condition
    // The second list contains all items that do not match the condition
    // Output as a Pair<T,T> type
    val (positiveMatches, negativeMatches) = numbers.partition { it > 0 }

    // "flatMap" and "flatten" == SelectMany == Collect
    // Takes a list of lists and flattens into a single collection of elements
    // "flatMap" lets you define a predicate that operates over each list in the list
    // "flatten" just combines the lists
    val elements = listOf(
        listOf("A", "B", "C"),
        listOf("D", "E", "F"),
        listOf("G", "H", "I")
    )

    val doubleList = elements.flatten() // Combines into a List<string> of A,B,C,D,E,F,G,H,I

    // "minOrNull" and "maxOrNull" return either the smallest or largest element in a collection
    // If the collection is empty, null is returned rather than an exception being thrown
    val smallest = numbers.minOrNull()
    val biggest = numbers.maxOrNull()

    // "sorted" & "sortedDescending" reorder a collection
    // "sortedBy" & "sortedByDescending" do the same but with a predicate to define how to sort
    val inAscendingOrder = numbers.sorted()
    val inDescendingOrder = numbers.sortedDescending()
    val sortedByName = people.sortedBy { it.name }

    // Accessing elements in a Map can be done using the "[]" syntax
    // Returns the value itself, in this case a list of people who live in Montreal
    val peopleInMontreal = peopleCities["Montreal"]

    // By default a Map will throw an error if the key doesn't exist
    // You can override this by creating a default for the Map
    // Interestingly this doesn't change the type of Map to denote a default exists
    // so you have to infer this has been done in code
    val mapWithDefault = peopleCities.withDefault { emptyList() }

    // "zip" combines two lists into a list of pairs by default
    // Iterating over both lists in order combining the elements together
    // Where there ar more elements in one of the lists than the other, it will discard them
    val a = listOf("a", "b", "c")
    val b = listOf(1, 2, 3, 4)

    // Can use the infix notation here to create a List<Pair<String, Int>>
    val resultPairs = a zip b
    // Or the standard function notation
    val resultPairs2 = a.zip(b)

    // You can also change the output type from a Pair using a predicate
    // This outputs a List<String> instead of a list of pairs
    val resultsReduced = a.zip(b) { elementA, elementB -> "$elementA$elementB"}

    // "getOrElse" is a somewhat aggressively named function that provides safer access that "[]"
    // to get elements out of a collection.  Works on Lists, Sets and Maps
    // Gets the element at position 1 in the list, or returns -1
    println(numbers.getOrElse(1) { -1 })

    // Gets the value matching key "Montreal" or returns an empty list
    println(peopleCities.getOrElse("Montreal") { emptyList() })
}