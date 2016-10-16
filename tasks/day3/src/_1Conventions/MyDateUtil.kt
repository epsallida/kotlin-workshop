package _1Conventions

import _1Conventions.TimeInterval.*
import java.time.LocalDate
import java.util.*

fun MyDate.nextDay() = addTimeIntervals(DAY, 1)

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
    val localDate = LocalDate.of(year, month, dayOfMonth)
    val newDate = when (timeInterval) {
        DAY -> localDate.plusDays(number.toLong())
        WEEK -> localDate.plusWeeks(number.toLong())
        YEAR -> localDate.plusYears(number.toLong())
    }
    return MyDate(newDate.year, newDate.monthValue, newDate.dayOfMonth)
}

fun MyDate.addTimeIntervalsJava7(timeInterval: TimeInterval, number: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year + if (timeInterval == YEAR) number else 0, month, dayOfMonth)
    val millisecondsInADay = 24 * 60 * 60 * 1000L
    val timeInMillis = c.timeInMillis + number * when (timeInterval) {
        DAY -> millisecondsInADay
        WEEK -> 7 * millisecondsInADay
        YEAR -> 0L
    }
    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis
    return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
}