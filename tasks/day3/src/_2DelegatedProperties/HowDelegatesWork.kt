package _2DelegatedProperties

import _1Conventions.MyDate
import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
Implement the members of the class 'EffectiveDate' so it can be delegated to.
Store only the time in milliseconds in 'timeInMillis' property.
Use the extension functions 'MyDate.toMillis' and 'Long.toDate'.
 */

class D {
    var date by EffectiveDate()
    // The property date$delegate of type EffectiveDate is created;
    // the generated 'get' and 'set' accessors for 'date' are delegated to it.
    // You can look at the bytecode (by calling "Show Kotlin Bytecode" action in IntelliJ IDEA) for details.
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {
    var timeInMillis: Long? = null
    operator override fun getValue(thisRef: R, property: KProperty<*>): MyDate = this.timeInMillis!!.toDate()
    operator override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        this.timeInMillis = value.toMillis()
    }
}

fun MyDate.toMillis(): Long {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    return c.timeInMillis
}

fun Long.toDate(): MyDate {
    val c = Calendar.getInstance()
    c.timeInMillis = this
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}
