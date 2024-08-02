import java.util.*

// https://leetcode.com/problems/k-closest-points-to-origin/description/

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    points.sortBy { it[0] * it[0] + it[1] * it[1] }
    return points.take(k).toTypedArray()
}

fun kClosest2(points: Array<IntArray>, k: Int): Array<IntArray> {
    val q = PriorityQueue<IntArray> { a, b ->
        (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
    }
    points.forEach { point ->
        q.add(point)
        if (q.size > k) q.poll()
    }
    return q.toTypedArray()
}