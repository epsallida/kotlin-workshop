package _3Collections.memberReferences

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 20), Person("Bob", 30))

    println(people.groupBy { it.age })

    println(people.groupBy(Person::age))
}