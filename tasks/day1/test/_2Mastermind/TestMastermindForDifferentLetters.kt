package _2Mastermind

import org.junit.Assert
import org.junit.Test

open class TestDifferentLetters() {
    open fun evaluate(secret: String, guess: String) = evaluateGuessForDifferentLetters(secret, guess)

    fun testEvaluation(secret: String, guess: String, expectedPositions: Int, expectedLetters: Int) {
        val (actualPositions, actualLetters) = evaluate(secret, guess)
        Assert.assertEquals("Wrong positions for secret $secret, guess $guess:", expectedPositions, actualPositions)
        Assert.assertEquals("Wrong letters for secret $secret, guess $guess:", expectedLetters, actualLetters)
    }

    @Test
    fun testEqual() = testEvaluation("ABCD", "ABCD", 4, 0)

    @Test
    fun testSwap() = testEvaluation("ABCD", "ABDC", 2, 2)

    @Test
    fun test3Positions() = testEvaluation("ABCD", "ABCF", 3, 0)

    @Test
    fun test3Letters() = testEvaluation("DAEF", "FECA", 0, 3)

    @Test
    fun testTaskSample() = testEvaluation("ACEB", "BCDF", 1, 1)
}