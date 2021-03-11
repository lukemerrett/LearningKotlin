package e_collections

// Lists are ordered collections
// List<T> is immutable
// MutableList<T> is mutable
val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)

// Casting a mutable list into an immutable list
// Is a readonly view, any additions to systemUsers will also be in sudoers
val sudoers: List<Int> = systemUsers

fun addSudoer(newUser: Int) {
    systemUsers.add(newUser)
}

fun getSysSudoers(): List<Int> {
    return sudoers
}

fun main() {
    addSudoer(4)
    println("Total sudoers: ${getSysSudoers().size}")
    getSysSudoers().forEach {
        println("Some useful info on user $it")
    }
}