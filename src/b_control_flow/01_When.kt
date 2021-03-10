package b_control_flow

// Kotlin's version of pattern matching comes from the "when" syntax
// Pattern matching can initially be thought of as a much more powerful switch expression

fun main() {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")

    oldEnoughToDrink(33, Country.England)
    oldEnoughToDrink(15, Country.Germany)
}

fun cases(obj: Any) {
    // Executed in order, stops when the first condition is met
    when(obj) {
        // Exact matches
        1 -> println("One")
        "Hello" -> println("Greeting")
        // Type matches
        is Long -> println("Long")
        !is String -> println("Not a string")
        // Catch remaining cases
        else -> println("Unknown")
    }
}

// Showing how to return a value from a when expression
fun oldEnoughToDrink(number: Int, country: Country): Boolean {
    return when (country) {
        Country.England -> when {
            number >= 18 -> true
            else -> false
        }
        Country.UnitedStates -> when {
            number >= 21 -> true
            else -> false
        }
        Country.Germany -> when {
            number >= 16 -> true
            else -> false
        }
        Country.Libya -> false
    }
}

class MyClass

enum class Country {
    England,
    UnitedStates,
    Germany,
    Libya
}