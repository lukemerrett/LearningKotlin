package c_special_classes

// Data classes are comparable to record types
// They auto generate equality based on properties ("==" and "hashCode")
// They also auto generate a toString representation of the contents
// And provide a way to copy classes with modifications
data class User(val name: String, val id: Int)

fun main() {
    val user = User("Jim", 1)
    println(user) // Outputs "User(name=Jim, id=1)"

    val secondUser = User("Jim", 1)
    val thirdUser = User("Moe", 2)

    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    println(user.copy()) // Creates an identical copy
    println(user.copy(name = "Max")) // Creates a copy and changes the name property

    // Auto generated properties to get values based on the order they were passed in
    // But as the actual named properties are available, I can't see when you'd use these
    println(user.component1())
}