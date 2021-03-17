package g_delegation

import kotlin.reflect.KProperty

// Properties in Kotlin can have their get/set functions delegated off to other objects
// Rather than at class level, this is at property level

class Example {
    // The getter and setter of this property are implemented in Delegate
    var property: String by Delegate()

    override fun toString() = "Example Class"
}

class Delegate() {
    private var internalProp: String = ""

    // Implementation of the getters and setters for the "p" property
    operator fun getValue(example: Example, property: KProperty<*>): String {
        return "$example, thank you for delegating '${property.name}' to me!. Value is $internalProp"
    }

    // Only needed for "var" mutable props, can be omitted for "val" props
    operator fun setValue(example: Example, property: KProperty<*>, value: String) {
        internalProp = value;
        println("$value has been assigned to ${property.name} in $example")
    }

}

// Kotlin has a set of useful delegates you can apply to properties out the box

// The first is the "lazy" type, which allows properties to be initialised once they are first called
// Rather than when the class is created
class LazyProperties {
    // "lazyString" will only be set to "now we're created" when it's getter is first called
    val lazyString: String by lazy {
        "now we're created"
    }
}

// There is also the "map" delegate type for properties that allows you to initialize properties
// from a Map<String, Any?>, useful for deserialization or other dynamic things
class Person(private val map: Map<String, Any?>) {
    // Will be initialised by a value where the key matches the property name in the Map
    private val firstName: String by map
    private val lastName: String by map

    val age: Int by map

    fun getName(): String { return "$firstName $lastName" }
}

fun main() {
    val props = mapOf(
        "firstName" to "Billy",
        "lastName" to "Talent",
        "age" to 28
    )
    val person = Person(props)

    println("name = ${person.getName()}, age = ${person.age}")
}