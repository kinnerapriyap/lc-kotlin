// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
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

fun lengthOfLongestSubstring2(s: String): Int {
    val listOfCharacters = mutableListOf<Char>()
    var max = 0
    var start = 0
    var end = 0

    while (end < s.length) {
        if (listOfCharacters.contains(s[end])) {
            listOfCharacters.remove(s[start])
            start++
        } else {
            listOfCharacters.add(s[end])
            end++
            max = maxOf(max, listOfCharacters.size)
        }
    }

    return max
}
