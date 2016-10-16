package _2DelegatedProperties

import org.junit.Assert
import org.junit.Test
import kotlin.reflect.KProperty

class TestPropertyChangeListener {
    data class Observation(val propertyName: String, val oldValue: Any?, val newValue: Any?)

    @Test
    fun testOneObserver() {
        val person = Person("Alice", 21, 2000)
        val observations1 = mutableListOf<Observation>()

        person.addObserver { kProperty, oldValue, newValue ->  observations1.add(Observation(kProperty.name, oldValue, newValue))}
        person.age++
        person.salary = 2500
        Assert.assertEquals(listOf(Observation("age", 21, 22), Observation("salary", 2000, 2500)), observations1)
    }

    @Test
    fun testTwoObservers() {
        val person = Person("Alice", 21, 2000)
        val observations1 = mutableListOf<Observation>()
        val observations2 = mutableListOf<Observation>()

        person.addObserver { kProperty, oldValue, newValue ->  observations1.add(Observation(kProperty.name, oldValue, newValue))}
        person.addObserver { kProperty, oldValue, newValue ->  observations2.add(Observation(kProperty.name, oldValue, newValue))}
        person.age++
        person.salary = 2500
        Assert.assertEquals(listOf(Observation("age", 21, 22), Observation("salary", 2000, 2500)), observations1)
        Assert.assertEquals(listOf(Observation("age", 21, 22), Observation("salary", 2000, 2500)), observations2)
    }

    @Test
    fun testRemoveObservers() {
        val person = Person("Alice", 21, 2000)
        val observations1 = mutableListOf<Observation>()
        val observations2 = mutableListOf<Observation>()

        person.addObserver { kProperty, oldValue, newValue ->  observations1.add(Observation(kProperty.name, oldValue, newValue))}
        val  secondObserver: (KProperty<*>, Any?, Any?) -> Unit = { kProperty, oldValue, newValue -> observations2.add(Observation(kProperty.name, oldValue, newValue)) }
        person.addObserver(secondObserver)
        person.age++
        person.removeObserver(secondObserver)
        person.salary = 2500
        Assert.assertEquals(listOf(Observation("age", 21, 22), Observation("salary", 2000, 2500)), observations1)
        Assert.assertEquals(listOf(Observation("age", 21, 22)), observations2)
    }
}