package _1Intro

fun main(args: Array<String>) {
    // read-only - like final in JAVA
    val question: String =
            "life, the universe, " +
                    "and everything"
    println("$question?")

    // mutable
    var answer: Int = 0
    answer = 42
    println(answer)

//    answer = "no answer"

    // val is read-only reference, not object
    val languages = mutableListOf("Java")
    languages.add("Kotlin")
}