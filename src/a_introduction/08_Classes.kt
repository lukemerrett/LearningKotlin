package a_introduction

/*
    Classes in Kotlin work like records types, in that a lot is auto generated for you
    However to get the full record type benefits, look at Data Classes later on
 */

// Creates an empty class with a default constructor taking no arguments
class Customer

// Creates a class with 2 properties and a default constructor taking 2 arguments
class Contact(val id: Int, var email: String)

fun main() {
    val customer = Customer()

    val firstContact = Contact(1, "mary@gmail.com")

    println(firstContact.id)
    firstContact.email = "jane@gmail.com"

    val secondContact = Contact(1, "jane@gmail.com")

    // Unlike record types in C#/F#, classes are not automatically generated with property based equality checks
    // Look at Data Classes for a record type equivalent
    println(firstContact == secondContact)

    // Unlike record types in C#/F#, classes are not automatically generated with a ToString that outputs all props
    // Look at Data Classes for a record type equivalent
    println(firstContact)
}