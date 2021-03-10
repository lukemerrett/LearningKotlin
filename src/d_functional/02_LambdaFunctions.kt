package d_functional

// Lambdas are inline ad hoc functions that can be declared
// They can be declared in a number of ways

// The most verbose way to declare a lambda
val upperCase1: (String) -> String = { str: String -> str.toUpperCase() }

// Slightly lighter weight, inferring the type in the body from the declaration
val upperCase2: (String) -> String = { str -> str.toUpperCase() }

// Lighter still, uses type inference to build the declaration from the function body
val upperCase3 = { str: String -> str.toUpperCase() }

// In many cases you can use "it" as shorthand for a single parameter lambda
// Rather than explicitly declaring the type
val upperCase5: (String) -> String = { it.toUpperCase() }

// You can also use function pointers ("::") to just point to another function
val upperCase6: (String) -> String = String::toUpperCase