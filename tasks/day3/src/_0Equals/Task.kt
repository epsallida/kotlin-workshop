package _0Equals

fun eq1(s1: String?, s2: String?): Boolean {
    return s1 == s2
}

fun eq2(s1: String?, s2: String?): Boolean = s1?.equals(s2) ?: (s2 === null)