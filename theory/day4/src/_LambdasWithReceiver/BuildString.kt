package _LambdasWithReceiver

fun buildString1(
        builderAction: (StringBuilder) -> Unit
): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

fun buildString2(
        builderAction: StringBuilder.() -> Unit
): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

fun main(args: Array<String>) {
    buildString1 {
        it.append("Alphabet: ")
        for (c in 'a'..'z') {
            it.append(c)
        }
    }

    buildString2 {
        this.append("Alphabet: ")
        for (c in 'a'..'z') {
            this.append(c)
        }
    }
}