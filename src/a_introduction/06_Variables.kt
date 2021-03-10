package a_introduction

fun main() {
    // "var" == variable, mutable
    // Here the type is explicitly declared,
    // though usually you'd do so through type inference if initialising at the same time
    var a: String = "initial"

    // "val" == value, immutable
    val b: Int = 1
    val c = 3

    // Both "var" and "val" can be declared without initialisation
    val d: Int
    if (a == "Banana") {
        d = 1
    } else {
        d = 2
    }

    // Side Note: you can join conditional initialisation like the above with the declaration
    val bob = if (a == "Banana") {
        1
    } else {
        2
    }

    // Side Note: or the expression can be simplified further
    val bill = if (a == "Banana") 1 else 2
}