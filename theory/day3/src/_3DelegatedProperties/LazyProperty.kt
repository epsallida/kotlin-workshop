package _3DelegatedProperties

data class Email(val text: String)

fun loadEmails(person: Person): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(Email("email1"))
}

// =, get
class Person(val name: String) {
    val emails by lazy { loadEmails(this) }
}

fun main(args: Array<String>) {
    val p = Person("Alice")
    println("---")
    println(p.emails)
    println("---")
    println(p.emails)
}