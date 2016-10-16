package libraryFunctions

fun main(args: Array<String>) {
    val s = "abCDa"

    println(s.filter { it in 'a'..'z' }) // aba
    println(s.map { it.toInt() })  // [97, 98, 67, 68, 97]

    println(s.maxBy { it.toInt() }) // b

    println(s.count { it == 'a' }) // 2
    println(s.any { it == 'a' })   // true     // cmd +b to navigate to the docs
    println(s.all { it == 'a' })   // false
    println(s.none { it == 'a' })  // false
    println(s.find { it in 'A'..'Z' }) // C

    s.withIndex().forEach {
        print("${it.index}${it.value}")  // 0a1b2C3D4a
    }
    println()

    println("ABCD".zip("1234"))  // [(A, 1), (B, 2), (C, 3), (D, 4)]

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })  // [a, b, c, d, e, f]

    val (lowerCase, upperCase) = s.partition { it in 'a'..'z' }
    println(lowerCase)    // aba
    println(upperCase)    // CD

    // the similar functions can be called on collections
}