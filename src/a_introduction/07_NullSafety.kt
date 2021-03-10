package a_introduction

fun main() {

    var neverNull: String = "This can't ever be set to null, even though it's a mutable type"

    // Kotlin does not allow assignment of null unless the type is marked as a nullable type
    // This generates a compile time error
    // neverNull = null

    var nullable: String? = "This can be set to null"

    // This can be set to null, as we've explicitly said the type could be null
    nullable = null

    var inferredNonNull = "By default all inferred types are assumed to be non-null"

    // So this will generate a compiler error
    // inferredNonNull = null

    // This function cannot accept a null string as we've not used a null type
    fun strLength(notNull: String): Int {
        return notNull.length
    }

    // Totally fine
    strLength(neverNull)

    // Generates a compiler error as this type could be null
    // strLength(nullable)
}