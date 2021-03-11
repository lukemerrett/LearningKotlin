package e_collections

// Maps == Dictionary<T,T> in other languages
// A collection of key value pairs where each key must be unique
// There is Map (immutable) and MutableMap

const val POINTS_X_PASS = 15

val Accounts: MutableMap<Int, Int> = mutableMapOf(
    // The "to" infix creates a Key/Value pair with the left side being the key
    1 to 100,
    2 to 100,
    3 to 100
)

// Creates a readonly view over the data
val Report: Map<Int, Int> = Accounts

fun updatePointsCredit(accountId: Int) {
    if (Accounts.containsKey(accountId)) {
        println("Updating $accountId...")
        Accounts[accountId] = Accounts.getValue(accountId) + POINTS_X_PASS
    } else {
        println("Error: Trying to update a non-existing account (id: $accountId)")
    }
}

fun accountsReport() {
    println("Report:")
    Report.forEach {
        (k, v) -> println("ID $k: credit $v")
    }
}

fun main() {
    accountsReport()
    updatePointsCredit(1)
    updatePointsCredit(2)
    updatePointsCredit(5)
    accountsReport()
}