package _1Game

import _1Game.Direction.*
import java.util.*

enum class Direction {
    UP, DOWN, RIGHT, LEFT
}

fun Direction.reversed() = when (this) {
    UP -> DOWN
    DOWN -> UP
    RIGHT -> LEFT
    LEFT -> RIGHT
}

fun generateRandomStartValue(): Int = if (Random().nextInt(10) == 9) 4 else 2

// 2, 0, 2, 4 transforms to 4, 4, 0, 0
fun moveAndMergeValues(values: List<Int>): List<Int> = TODO()

interface Board {
    fun canMove(): Boolean
    fun has2048(): Boolean

    operator fun set(i: Int, j: Int, value: Int)
    operator fun get(i: Int, j: Int): Int

    fun addRandomValue()
    fun moveValues(direction: Direction): Boolean
}

class BoardImpl: Board {

    override fun canMove(): Boolean = TODO()

    override fun has2048(): Boolean = TODO()

    override fun set(i: Int, j: Int, value: Int) = TODO()

    override fun get(i: Int, j: Int): Int = TODO()

    override fun addRandomValue() = TODO()

    override fun moveValues(direction: Direction) = TODO()
}
