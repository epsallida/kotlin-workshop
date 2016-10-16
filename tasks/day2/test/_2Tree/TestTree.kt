package _2Tree

import org.junit.Assert
import org.junit.Test
import _2Tree.Task.*

class TestTree {
    @Test
    fun testEmpty() {
        Assert.assertEquals(null, Empty.max())
    }

    @Test
    fun testLeaf() {
        Assert.assertEquals(2, Leaf(2).max())
    }

    @Test
    fun testSimpleNode() {
        val node = Node(Empty, Leaf(2))
        Assert.assertEquals(2, node.max())
    }

    @Test
    fun testNode() {
        val node = Node(Leaf(1), Leaf(2))
        Assert.assertEquals(2, node.max())
    }

    @Test
    fun testTree() {
        val tree = Node(Node(Leaf(3), Leaf(1)), Node(Empty, Node(Leaf(1), Leaf(2))))
        Assert.assertEquals(3, tree.max())
    }
}