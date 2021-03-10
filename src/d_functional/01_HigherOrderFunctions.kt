package d_functional

// Kotlin treats functions as first class citizens
// Therefore you can create higher order functions; that is functions that take other functions
fun calculate(
    x: Int,
    y: Int,
    // Function this one takes in, which takes 2 integers and returns an integer
    operation: (Int, Int) -> Int): Int {
    return operation(x,y)
}

fun sum(x: Int, y: Int) = x + y

// You can return functions as well
fun generateMultiplier(multiplyBy: Int): (Int) -> Int {
    fun multiply (a: Int) = a * multiplyBy
    return ::multiply
}

fun main() {
    // Note the "::" syntax, which denotes that a reference to a function should be passed in
    val sumResult = calculate(4, 5, ::sum)

    // This nutty syntax is to pass in an anonymous function
    // ... I kind of like it
    val mulResult = calculate(4, 5) { a, b -> a * b}

    println("sumResult $sumResult, mulResult $mulResult")

    val multiplyByFive = generateMultiplier(5)
    println(multiplyByFive(4))
}