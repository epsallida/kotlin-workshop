package _2Mastermind

import org.junit.Test

class TestRepetitiveLetters() : TestDifferentLetters() {
    override fun evaluate(secret: String, guess: String) = evaluateGuessForRepetitiveLetters(secret, guess)

    @Test
    fun testSample() = testEvaluation("AAAF", "ABCA", 1, 1)

    @Test
    fun testReversedSample() = testEvaluation("ABCA", "AAAF", 1, 1)

    @Test
    fun testSecretLetter1() = testEvaluation("AABC", "DEFA", 0, 1)

    @Test
    fun testSecretLetter2() = testEvaluation("EDEB", "CBFE", 0, 2)

    @Test
    fun testSecretLetter3() = testEvaluation("CFDF", "FCCD", 0, 3)


    @Test
    fun testSecretPosition1() = testEvaluation("AABC", "AEFD", 1, 0)

    @Test
    fun testSecretPosition2() = testEvaluation("DCFC", "ABEC", 1, 0)

    @Test
    fun testSecretPosition3() = testEvaluation("FDCD", "FBAD", 2, 0)

    @Test
    fun testGuess() = testEvaluation("DEFA", "AABC", 0, 1)

    @Test
    fun testBothOneLetter() = testEvaluation("DAAE", "AABC", 1, 1)

    @Test
    fun testBothSeveralLetters1() = testEvaluation("BBDC", "DFBB", 0, 3)

    @Test
    fun testBothSeveralLetters2() = testEvaluation("DBFF", "FFDD", 0, 3)

    @Test
    fun testBothOnePosition1() = testEvaluation("BDAD", "AAAE", 1, 0)

    @Test
    fun testBothOnePosition2() = testEvaluation("FDDB", "CABB", 1, 0)

    @Test
    fun testBothPositions() = testEvaluation("BDBC", "DDFC", 2, 0)

    @Test
    fun testBothLettersAndPositions() = testEvaluation("ECDE", "CEEE", 1, 2)
}