package _2ControlStructures

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
// c in 'a'..'z'
// is compiled to:
// 'a' <= c && c <= 'z'

fun isNotDigit(c: Char) = c !in '0'..'9'

fun main(args: Array<String>) {
    println(isLetter('q'))     // true
    println(isNotDigit('x'))   // true
}

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know…​"
}

fun whatWillBePrinted() {
    println("Kotlin" in "Java".."Scala") //true: it compares Strings alphabetically
    println("Kotlin" in setOf("Java", "Scala"))
}

fun ranges() {
    val intRange = 1..10
    for (i in intRange) { /*...*/ }
    for (i in 1..10) { /*...*/ }

    val list = listOf(1, 2)
    if (3 in list) { /*...*/ }
    // is compiled to:
    // list.contains(3)
}

fun foo() {
    for (c in '0'..'9') {
        println(c)
    }
}