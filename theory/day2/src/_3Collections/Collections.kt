package collections

fun create() {

    // read-only

    val list = listOf(1, 2, 3)
    val set = setOf(1, 2, 3)
    val map = mapOf(1 to "one", 2 to "two")

    // mutable

    val arrayList = mutableListOf(1, 2, 3)
    val mutableSet = mutableSetOf(1, 2, 3)
    val mutableMap = mutableMapOf(1 to "one", 2 to "two")
}

fun iteratingWithIndex(list: List<String>) {
    for (index in list.indices) {
        println("$index. ${list[index]}")
    }
    for ((index, s) in list.withIndex()) {
        println("$index. $s")
    }
}