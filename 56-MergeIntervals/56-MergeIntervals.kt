// Last updated: 5/4/2026, 7:18:57 PM
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return emptyArray()

        val sorted = intervals.sortedBy { it[0] }
        val result = mutableListOf(sorted[0])

        for (i in 1..<sorted.size) {
            val (x1, y1) = result.last()
            val (x2, y2) = sorted[i]

            if (y1 >= x2) {
                result[result.size - 1] = intArrayOf(x1, maxOf(y1, y2))
            } else {
                result.add(intArrayOf(x2, y2))
            }
        }

        return result.toTypedArray()
    }
}