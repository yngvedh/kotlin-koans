package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = days() - other.days()

    operator fun plus(interval: TimeInterval) : MyDate = this.addTimeIntervals(interval, 1)
    operator fun plus(multipleInterval: MultipleTimeInterval) : MyDate =
            this.addTimeIntervals(multipleInterval.interval, multipleInterval.times)

    private fun days() : Int = dayOfMonth+month*32+year*384
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(n:Int) = MultipleTimeInterval(this, n)
}

class MultipleTimeInterval(val interval: TimeInterval, val times: Int)

class DateRange(override val start: MyDate, override val endInclusive: MyDate)
    : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return DateIterator(this)
    }

    class DateIterator(private val range: DateRange) : Iterator<MyDate> {
        var nextDate = range.start

        override fun next(): MyDate {
            val ret = nextDate
            nextDate = nextDate.nextDay()
            return ret
        }

        override fun hasNext(): Boolean = range.contains(nextDate)
    }
}

