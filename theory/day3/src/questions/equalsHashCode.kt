package questions

class Value(val v: Int) {
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other !is Value) return false

        return v == other.v
    }
    // hashcode should be overridden also here in order to be totally correct
}

fun main(args: Array<String>) {
    val v = Value(2)
    println(v == v)                     // true

    println(Value(13) == Value(13))     // true

    val set = hashSetOf(Value(1), Value(2))
    println(set.contains(Value(1)))     // false
}

//If you fail to do so, you will end up with broken objects. Why? An object’s hashCode method must take the same
//fields into account as its equals method. By overriding the equals method, you’re declaring some objects as equal
//to other objects, but the original hashCode method treats all objects as different. So you will have equal objects
//with different hash codes. For example, calling contains() on a HashMap will return false, even though the object has
//been added.