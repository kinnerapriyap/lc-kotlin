fun lengthOfLongestSubstring(s: String): Int {
    var (start, end) = 0 to 0
    var max = 0
    s.forEach { c ->
        val sub = s.substring(start, end)
        end++
        if (c in sub) start += sub.indexOf(c) + 1
        max = maxOf(max, end - start)
    }
    return max
}
