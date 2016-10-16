package _1Game

import _1Game.Direction.*
import org.junit.Assert
import org.junit.Test

class TestMove : AbstractTestGameWithSmallNumbers() {

    @Test
    fun testSimpleMove1() = testAllDirections("0000 0000 0200 0000", "0000 0000 0002 0000")

    @Test
    fun testNoMove() = testAllDirections("0000 0000 0000 2424", "0000 0000 0000 2424")

    @Test
    fun testSeveralMoves() = testAllDirections("2000 0200 0020 0002", "0002 0002 0002 0002")

    @Test
    fun testMoveAndMerge() = testAllDirections("2020 0202 0020 0002", "0004 0004 0002 0002")

    fun testRegularAndReversedDirections(direction: Direction, input: String, expected: String) {
        testMove(direction, input, expected)
        testMove(direction.reversed(), input.reversed(), expected.reversed())
    }

    fun testAllDirections(input: String, expected: String) {
        testRegularAndReversedDirections(RIGHT, input, expected)
        testRegularAndReversedDirections(DOWN, input.turn(), expected.turn())
    }

    fun String.turn(): String {
        val values = toValues()
        return valuesToString { i, j -> values[j][i] }
    }

    fun testMove(direction: Direction, input: String, expected: String) {
        val board = createBoard(input)
        board.moveValues(direction)
        val result = board.print()
        Assert.assertEquals("Incorrect move to $direction.\nInput:    $input", expected, result)
    }
}