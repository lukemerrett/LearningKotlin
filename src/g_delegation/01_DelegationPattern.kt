package g_delegation

import b_control_flow.Zoo

// The Delegation Pattern is an alternative to inheritable for code reuse
// Resources:
//  - https://kotlinlang.org/docs/delegation.html
//  - https://en.wikipedia.org/wiki/Delegation_pattern
//  - https://lankydan.dev/kotlin-implementing-multiple-interfaces-through-delegation

interface SoundBehaviour {
    fun makeSound()
}

class ScreamBehaviour(private val soundToMake: String) : SoundBehaviour {
    override fun makeSound() = println("${soundToMake.toUpperCase()} !!!")
}

class RockAndRollBehaviour(private val soundToMake :String): SoundBehaviour {
    override fun makeSound() = println("I'm The King of Rock 'N' Roll: $soundToMake")
}

// This is the delegation pattern. Rather than implementing the interface,
// they delegate the implementation to another object with the behaviour defined
class TomAraya(soundToMake: String): SoundBehaviour by ScreamBehaviour(soundToMake)
class ElvisPresley(soundToMake: String): SoundBehaviour by RockAndRollBehaviour(soundToMake)

// A type can implement multiple interfaces, and delegate them each off too
interface Animal { val name: String }
interface ToBeFed { fun feed()  }

class ZooAnimal(override val name: String) : Animal

class Feeder : ToBeFed {
    override fun feed() {
        println("Animal fed")
    }
}

class Crocodile(name: String) : Animal by ZooAnimal(name), ToBeFed by Feeder()

// You can also delegate to parameters passed into a type
class Zebra(animal: Animal, feeder: ToBeFed) : Animal by animal, ToBeFed by feeder