// Last updated: 8/1/2026, 11:13:24 PM
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0

        var i = 0
        var j = 0

        while (i < haystack.length) {
            if (haystack[i] == needle[j]) {
                i++
                j++

                if (j == needle.length) {
                    return i - j
                }
            } else {
                i = i - j + 1
                j = 0
            }
        }

        return -1
    }
}