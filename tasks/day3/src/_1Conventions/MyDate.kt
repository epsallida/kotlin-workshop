package _1Conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
//        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        when {
            this.year < other.year -> return -1
            // this.year ! other.year -> this.year - other.year
            this.year == other.year && this.month < other.month -> return  -1
            this.year == other.year && this.month == other.month && this.dayOfMonth < other.dayOfMonth -> return -1
            this == other -> return 0
            else -> return 1
        }
    }
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate> { }

//task 3
operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

infix operator fun MyDate.plus(timeInterv: TimeInterval): MyDate {
    return this.addTimeIntervals(timeInterv, 1)
}

infix operator fun TimeInterval.times(number: Int): Pair<TimeInterval, Int> {
    return Pair(this, number)
}

infix operator fun MyDate.plus(pair: Pair<TimeInterval, Int>): MyDate {
    return this.addTimeIntervals(pair.first, pair.second)
}
