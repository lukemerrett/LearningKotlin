package a_introduction

// By default classes in Kotlin are final, so need to be marked with open to be inherited from
// The same is true of methods
open class Dog {
    open fun sayHello() {
        println("wow wow!")
    }
}

// ": Dog()" is how we specify the superclass
// This is when there is an empty constructor
class YorkshireTerrier : Dog() {
    override fun sayHello() {
        println("wif wif!")
    }
}

open class Tiger(val origin: String) {
    fun sayHello() {
        println("A tiger from %origin says: grrhh!")
    }
}

// Here we are passing in the value the superclass expects through it's constructor
class SiberianTiger: Tiger("Siberia")

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}

// Here we are passing through the value the superclass expects from the subclass constructor
class AsiaticLion(name: String) : Lion(name = name, origin = "India")