package lambdas

fun basicSyntax() {
    val sum = { x: Int, y: Int -> x + y }

    val sum1: (Int, Int) -> Int = { x, y -> x + y }

    println(sum(1, 2)) // 3
}

fun shortSyntax() {
    val String = "one, two, three"

    println(String.filter({ c: Char -> c in 'a'..'z' }))   // "onetwothree"

    String.filter() { c: Char -> c in 'a'..'z' }

    String.filter { c: Char -> c in 'a'..'z' }

    String.filter { c -> c in 'a'..'z' }

    String.filter { it in 'a'..'z' }
}

fun main(args: Array<String>) {
    basicSyntax()
    shortSyntax()
}