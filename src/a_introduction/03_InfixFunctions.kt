package a_introduction

fun main() {
    // Functions and extensions with a single parameter can be turned into Infix functions
    // This allows you to use them inline with a much cleaner, DSL like syntax
    // Below is an example of a local function turned into an infix function
    // It is an extension function (a member on the Int type added after Int is created) we are using
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ") // Outputs "Bye Bye " Isn't that just gorgeous!

    val pair = "Ferrari" to "Katrina" // Creates a Pair<T,T> type (a tuple)
    println(pair)

    // "this" is the string to the left of the infix notation
    // Here we're making our own version of the "to" function used above to create a Pair
    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    // Side Note: demonstrating tuple deconstruction
    val (first, second) = myPair
    println("$first, $second")

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia

    // Demonstrating enumeration from the Kotlin Collections library
    sophia.likedPeople.forEach {
        // "it" is the inferred item in the collection
        println("${sophia.name} likes ${it.name}")
    }
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other)}
}

