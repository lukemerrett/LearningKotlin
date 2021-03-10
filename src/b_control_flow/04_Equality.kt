package b_control_flow

fun main() {
    // Using sets here to allow a comparison of the contained values
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    // In Kotlin "==" is structural comparison (check values with .equals() under the hood)
    // Whilst "===" is referential equals, checking their references in memory
    println(authors == writers)  // Will be true
    println(authors === writers) // Will be false
}