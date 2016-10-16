package _3Classes

// Pair - just a class in the standard library
fun functionReturningPair() = Pair(42, "answer")

fun main(args: Array<String>) {
    // you can assign to two variables
    val (i, s) = functionReturningPair()
    println(i)
}