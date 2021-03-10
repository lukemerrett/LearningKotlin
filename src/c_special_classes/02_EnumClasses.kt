package c_special_classes

// Enum classes are similar to Enums in other languages
// However like discriminated unions in F# and Scala, they can contain values
// Interestingly they can also contain functions
// Unlike discriminated unions, it isn't a first class algebraic type system it seems
// However in the next file we explore this a bit more with sealed classes and the "when" syntax

// Basic enum
enum class State { IDLE, RUNNING, FINISHED }

enum class Colour(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)
}

fun main() {
    val state = State.RUNNING
    val message = when (state) {
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)

    val red = Colour.RED
    println(red)
    println(red.containsRed())
    println(Colour.BLUE.containsRed())
}