package _1NiceStrings

import org.junit.Assert
import org.junit.Test

class TestNiceStrings {
    @Test
    fun testNice() {
        // all conditions are satisfied:
        // 1. it has at least three vowels (u...i...o...),
        // 2. a double letter (...dd...),
        // 3. and none of the disallowed substrings
        Assert.assertTrue("ugknbfddgicrmopn".isNice())
    }

    @Test
    fun testSimpleNice() {
        // it has at least three vowels and a double letter, even though the letters used by different rules overlap
        Assert.assertTrue("aaa".isNice())
    }

    @Test
    fun testVowelLetters() {
        // no double letter
        Assert.assertFalse("jchzalrnumimnmhp".isNice())
    }

    @Test
    fun testDuplicatedLetters() {
        // contains xy
        Assert.assertFalse("haegwjzuvuyypxyu".isNice())
    }

    @Test
    fun testBadWord() {
        // contains only one vowel
        Assert.assertFalse("dvszwmarrgswjxmb".isNice())
    }
}