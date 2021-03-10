package a_introduction

// Demonstrating a generic class in Kotlin
class MutableStack<E>(vararg items: E) {
    // Note how we have access to the passed in elements even though we have no explicit constructor
    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)
    fun peek(): E = elements.last()
    fun pop(): E = elements.removeAt((elements.size -1))
    fun isEmpty() = elements.isEmpty()
    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}

// Demonstrating a generic function
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

fun main() {
    val stack = mutableStackOf(0.62, 3.14, 2.7)
    println(stack)
}