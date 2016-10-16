package _1NiceStrings

// A nice string is one with all of the following properties:
//
// - It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
// - It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
// - It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
//
// Implement a function telling whether the string is nice.
//
// http://adventofcode.com/day/5

fun String.isNice(): Boolean {
    if (this.count { it in "aeiou" } != 3) {
        return false
    }
//    var i = 0
//    var j = 1
//    if ((j <= this.length && this[i] == this[j])) {
//        return false
//    }
    if((0 until length-1).none { i -> this[i] == this[i+1] })
        return false

    val mySet = setOf("ab", "cd", "pq", "xy")
    if (mySet.any {it in this})
        return false

    return true
}