package _1Nullability

fun main(args: Array<String>) {

    val s1: String = "always not null"
    val s2: String? = null

    val i1: Int = s1.length

    if (s2 != null) s2.length
    s2?.length

    val i2: Int? = if (s2 != null) s2.length else null
    val i3: Int? = s2?.length

    val i4: Int? = if (s2 != null) s2.length else 0
    val i5: Int = s2?.length ?: 0

   // s2!!

//    val ss1: String? = "test"
//    val ss2: String? = "test2"
//
//    println(eq1(ss1, ss2))
//    println(eq2(ss1, ss2))
}

fun test1(s: String?) {
    if (s == null) return
    s.length
}

fun test2(s: String?) {
    if (s == null) fail()
    s.length
}

fun test3(s: String?) {
    val i: Int = s?.length ?: fail()
}

fun fail(): Nothing =
  throw UnsupportedOperationException()

fun eq1(s1:String?, s2: String?): Boolean {
    return s1 == s2
}

//fun eq2(s1: String?, s2: String?) = s1?.equals(s2) ?: false && s1 === s2
//
