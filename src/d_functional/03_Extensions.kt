package d_functional

// You can add new members to any class with extensions
// Both new functions and properties

// Setting up two basic data types
data class Item(val name: String, val price: Float)
data class Order(val items: Collection<Item>)

// Add an extension method to Order
fun Order.maxPricedItemValue(): Float {
    // Note the null conditional operator that guards accessing price if the returned object is null
    // Note the null coalescing operator to return 0F if the left side object is null
    return this.items.maxByOrNull { it.price }?.price ?: 0F
}

// Add another extension method
fun Order.maxPricedItemName(): String {
    return this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"
}

// Extend Order by adding a new property as a member
val Order.commaDelimitedItemNames: String
    get() = items.joinToString { it.name }

fun main() {
    val items = listOf(
        Item("Bread", 25.0F),
        Item("Wine", 29.0F),
        Item("Water", 12.0F)
    )
    val order = Order(items)

    println("Max priced item name: ${order.maxPricedItemName()}")
    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Items: ${order.commaDelimitedItemNames}")
}