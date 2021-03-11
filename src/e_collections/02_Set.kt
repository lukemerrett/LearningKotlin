package e_collections

// Sets are unordered collections of unique values
// As with lists you can have a Set<T> as immutable, or MutableSet<T> as mutable
val openIssues: MutableSet<String> = mutableSetOf("A", "B", "C")

fun addIssue(id: String): Boolean {
    // Returns true if added, false if the item already existed in the set
    return openIssues.add(id)
}

fun getStatusLog(isAdded: Boolean): String {
    return if (isAdded) "registered correctly." else "marked as duplicate and rejected."
}

fun main() {
    val aNewIssue = "D"
    val anIssueAlreadyInSet = "B"

    println("Issue $aNewIssue ${getStatusLog(addIssue(aNewIssue))}")
    println("Issue $anIssueAlreadyInSet ${getStatusLog(addIssue(anIssueAlreadyInSet))}")
}