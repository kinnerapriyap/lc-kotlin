// https://leetcode.com/problems/insert-interval/description/

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val new = mutableListOf<IntArray>()
    var (start, end) = newInterval
    var i = 0
    while (i < intervals.size && intervals[i][1] < newInterval[0]) new.add(intervals[i++])
    while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
        start = minOf(start, intervals[i][0])
        end = maxOf(end, intervals[i][1])
        i++
    }
    new.add(intArrayOf(start, end))
    while (i < intervals.size) new.add(intervals[i++])
    return new.toTypedArray()
}