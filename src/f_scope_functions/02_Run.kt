package f_scope_functions

fun main() {
    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")

        // "run" is almost identical to "let", however the value is accessed differently
        // In "let" you access it with "it"
        // and any functions on the value you want to call are accessed by "it.myFunc()"
        // In "run" the scope changes as if you were inside the object
        // So you can call functions without needing to call "it"
        ns?.run {
            // Here we are calling the "isBlank" method on the string
            println("\tis empty? " + isBlank())
            // Here we are implicitly referencing the length value on the string
            println("\tlength = $length")
            length
        }
    }
    getNullableLength(null)
    getNullableLength("")
    getNullableLength("A value")
}