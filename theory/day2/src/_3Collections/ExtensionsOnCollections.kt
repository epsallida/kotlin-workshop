package _3Collections

// filter, count,
// any, all, none, find
// withIndex, zip
// (map, flatMap, maxBy, sumBy, partition)
// (sumByDouble, minus, plus)

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 20), Person("Bob", 30))

    val canBeInClub27 = { p: Person -> p.age <= 27 }


    println(people.all(canBeInClub27))
    println(people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.find(canBeInClub27))

    println(people.groupBy { it.age })

    println(people.maxBy { it.age })

    val mutableList = mutableListOf<Person>()
    mutableList += people
    mutableList -= Person("Charlie", 25)
}