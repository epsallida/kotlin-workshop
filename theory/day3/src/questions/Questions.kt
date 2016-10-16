package questions

fun main(args: Array<String>) {
    task1()
    task2()
    task3(listOf(), listOf())
    task4(null)
}

// 1
class Name(val value: String?)

fun isFoo1(n: Name) = n.value == "foo"
//fun isFoo2(n: questions.Name?) = n.value == "foo"
fun isFoo3(n: Name?) = n != null && n.value == "foo"
fun isFoo4(n: Name?) = n?.value == "foo"

fun task1() {
//    questions.isFoo1(null)
//    isFoo2(null)
    isFoo3(null)
    isFoo4(null)
}

// 2
fun eq1(s1: String?, s2: String?): Boolean {
    return s1 == s2
}

fun eq2(s1: String?, s2: String?) =
        s1?.equals(s2) ?: (s2 === null)

fun task2() {
    println(eq2("abc", "abc"))
    println(eq2(null, "abc"))
    println(eq2("abc", null))
    println(eq2(null, null))
}

// 3
fun task3(list1: List<Int?>, list2: List<Int>?) {
    list1.size
//    list2.size
//
//    val i: Int = list1.first()
//    val j: Int = list2.first()
}


// 4
fun task4(s: String?) {
    s.isNullOrEmpty()  //true
}

fun String?.isNullOrEmpty(): Boolean = this == null || this.length == 0

