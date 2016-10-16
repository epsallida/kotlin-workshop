package _2Tree

import _2Tree.Task.*

/*
Implement the function 'max' finding the maximum value stored in the tree.
The tree can store only positive values.
*/

sealed class Task {
    object Empty: Task()
    class Leaf(val x: Int): Task()
    class Node(val left: Task,
               val right: Task): Task()

    fun max(): Int? = when (this) {
        is Node -> Math.max(this.right.max() ?: 0, this.left.max() ?: 0)
        is Leaf -> this.x
        is Empty -> null
    }
}