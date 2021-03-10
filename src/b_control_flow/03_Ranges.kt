package b_control_flow

fun main() {
    // Simple integer range, under the hood this is an IntRange type
    // The 3 is inclusive (so outputs 0123)
    for (i in 0..3) {
        print(i)
    }
    print(" ")

    // Integer range using the "until" infix
    // The 3 is exclusive (so outputs 012)
    for(i in 0 until 3) {
        print(i)
    }
    print(" ")

    // The "step" infix defines a custom increment between values
    // Here, rather than jumping by 1 each time, it's 2
    // To output 2468
    for(i in 2..8 step 2) {
        print(i)
    }
    print(" ")

    // Reverse order range
    // Here the 0 is inclusive (so outputs 3210)
    for(i in 3 downTo 0) {
        print(i)
    }
    print(" ")

    // Char ranges are also supported
    // Includes support for until, step, downTo etc
    for (c in 'a'..'d') {
        print(c)
    }
    print(" ")

    // Ranges can be used in if and when checks too
    val x = 2
    if (x in 1..5) {
        print("x is in range from 1 to 5")
    }
    println()

    if (x !in 6..10) {
        print("x is not in range from 6 to 10")
    }
}