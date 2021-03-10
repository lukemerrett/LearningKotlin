package b_control_flow

fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")

class Animal(val name: String)

// You can set class arguments to private to reduce accessibility
class Zoo(private val animals: List<Animal>) {
    // Able to define your own iterator over elements as well
    // So they can be used in for expressions
    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}

fun main() {
    val cakes = listOf("carrot", "cheese", "chocolate")

    // for == foreach here, similar to a lot of languages
    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }

    var cakesEaten = 0
    var cakesBaked = 0

    // while and do while again work very similar to other languages
    while(cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }

    do {
        bakeACake()
        cakesBaked++
    } while(cakesBaked < cakesEaten)

    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))

    for(animal in zoo) {
        println("Watch out, it's a ${animal.name}")
    }
}