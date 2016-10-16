package _0Variance

/*
Task 2.
Try to break in the similar manner Array, List and MutableList in Kotlin.
What's the difference between List and MutableList?
*/

private fun foo(array: MutableList<String>) {
//    public interface List<out E> : Collection<E> {
//    array.add(1)
    array.add("eirini")
    // List doesn't allow to edit the list
    // MutableList and Array do not compile
}

private fun bar() {
    val strings = mutableListOf("a", "b", "c")
        foo(strings)
    for (string in strings) {
        println(string)
    }
}

fun main(args: Array<String>) {
    bar()
}