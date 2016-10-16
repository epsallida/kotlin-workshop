package _1Game

import org.junit.Assert
import org.junit.Test

class TestMergeOneRow {
    @Test
    fun testSimpleMove1() = testMerge(listOf(0, 0, 0, 2), listOf(2, 0, 0, 0))

    @Test
    fun testSimpleMove2() = testMerge(listOf(4, 0, 0, 2), listOf(4, 2, 0, 0))

    @Test
    fun testSimpleMove3() = testMerge(listOf(0, 4, 0, 2), listOf(4, 2, 0, 0))

    @Test
    fun testSimpleMerge1() = testMerge(listOf(2, 2, 0, 0), listOf(4, 0, 0, 0))

    @Test
    fun testSimpleMerge2() = testMerge(listOf(0, 2, 2, 0), listOf(4, 0, 0, 0))

    @Test
    fun testSimpleMerge3() = testMerge(listOf(0, 0, 2, 2), listOf(4, 0, 0, 0))

    @Test
    fun testSimpleMerge4() = testMerge(listOf(2, 0, 2, 0), listOf(4, 0, 0, 0))

    @Test
    fun testSimpleMerge5() = testMerge(listOf(2, 0, 0, 2), listOf(4, 0, 0, 0))

    @Test
    fun testSimpleMerge6() = testMerge(listOf(0, 2, 0, 2), listOf(4, 0, 0, 0))

    @Test
    fun testMergeWithExtraElement1() = testMerge(listOf(2, 0, 2, 2), listOf(4, 2, 0, 0))

    @Test
    fun testMergeWithExtraElement2() = testMerge(listOf(2, 0, 2, 4), listOf(4, 4, 0, 0))

    @Test
    fun testMergeWithExtraElement3() = testMerge(listOf(2, 2, 0, 4), listOf(4, 4, 0, 0))

    @Test
    fun testNoMerge1() = testMerge(listOf(2, 4, 2, 0), listOf(2, 4, 2, 0))

    @Test
    fun testNoMerge2() = testMerge(listOf(2, 0, 4, 2), listOf(2, 4, 2, 0))

    @Test
    fun testMergeInFull1() = testMerge(listOf(2, 2, 4, 2), listOf(4, 4, 2, 0))

    @Test
    fun testMergeInFull2() = testMerge(listOf(2, 2, 4, 4), listOf(4, 8, 0, 0))

    @Test
    fun testMergeOfThree1() = testMerge(listOf(2, 2, 2, 0), listOf(4, 2, 0, 0))

    @Test
    fun testMergeOfThree2() = testMerge(listOf(2, 0, 2, 2), listOf(4, 2, 0, 0))

    fun testMerge(input: List<Int>, expected: List<Int>) {
        val result = moveAndMergeValues(input)
        Assert.assertEquals(expected, result)
    }
}