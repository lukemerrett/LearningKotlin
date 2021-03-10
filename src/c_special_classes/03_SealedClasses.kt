package c_special_classes

// Can only be subclassed from inside the same file it is declared
sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    // See how we can access "job" once we've checked the type is "Human"?
    // This is pattern matching
    // It also shows we can use classes to build up algebraic data types (ADTs)
    return when(mammal) {
        is Human -> "Hello ${mammal.name}; you're working as a ${mammal.job}"
        is Cat -> "Hello ${mammal.name}"
    }
}

fun main() {
    val mammal = Cat("Snowy")
    println(greetMammal(mammal))
}