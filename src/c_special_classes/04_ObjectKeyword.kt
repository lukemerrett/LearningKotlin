package c_special_classes

// Classes and objects work the same way as other OO languages
// In that the class is the blueprint, the object is the instance

// However there is also the "object" keyword
// This can be used to create Singletons / statics
// These are created as lazy instances

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int) {
    // Object is used here to create an anonymous type
    // Really it's a utility here to ease in understanding / readability of code
    val dayRates = object {
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special

    print("Total price: $$total")
}

// Can also be used to create an anonymous singleton type
object DoAuth {
    fun takeParams(username: String, password: String) {
        println("input Auth parameters = $username:$password")
    }
}

// Companion objects are effectively a way of creating static method within a class
// So you can access them without instantiating the class
class BigBen {
    companion object Bonger {
        fun getBongs(nTimes: Int) {
            for (i in 1..nTimes) {
                print("BONG ")
            }
        }
    }
}

fun main() {
    rentPrice(10, 2, 1)

    DoAuth.takeParams("foo", "qwerty")

    BigBen.getBongs(5)
}