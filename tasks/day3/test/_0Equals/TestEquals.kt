package _0Equals

import org.junit.Assert
import org.junit.Test

class TestEquals {
    fun assertSimilar(s1: String?, s2: String?) {
        Assert.assertTrue(eq1(s1, s2) == eq2(s1, s2))
    }

    @Test
    fun test() {
        assertSimilar("abc", "abc")
        assertSimilar(null, "abc")
        assertSimilar("abc", null)
        assertSimilar(null, null)
    }
}