package _2DelegatedProperties

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/*
Support adding and removing observers to observe property changes.
*/

open class PropertyChangeAware {
    val observer: (KProperty<*>, Any?, Any?) -> Unit = TODO()

    fun addObserver(observer: (KProperty<*>, Any?, Any?) -> Unit) {
        TODO()
    }

    fun removeObserver(observer: (KProperty<*>, Any?, Any?) -> Unit) {
        TODO()
    }
}

class Person(
        val name: String, age: Int, salary: Int
): PropertyChangeAware()  {

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}