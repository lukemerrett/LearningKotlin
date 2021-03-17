package f_scope_functions

fun main() {
    data class Person(var firstName: String = "", var lastName: String = "")

    // "apply" is like an object initializer, useful for setting properties
    // It returns the modified object
    val person = Person().apply {
        firstName = "Gary"
        lastName = "Robbins"
    }

    fun Person.makeAdmin() {
        println("Now an admin")
    }

    // Similar to "apply", "also" executes code in a block and returns the object
    // Difference is that "apply" uses "this", whilst "also" uses "it"
    val personB = Person("Gary", "Robbins").also { it.makeAdmin() }
}