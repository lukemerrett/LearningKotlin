package f_scope_functions

fun main() {
    // "let" allows scoped execution of code and returns the value of the last expression
    // Anything defined in the let is only scoped to that wrapper
    val empty = "test".let {
        println(it)
        it.isBlank()
    }
    println(" is empty: $empty")

    fun printNonNull(str: String?) {
        println("Printing \"$str\":")

        // "let" can also be used to only execute code if the value being executed on isn't null
        str?.let {
            print(it)
            println()
        }
    }
    printNonNull(null)
    printNonNull("A value")
}