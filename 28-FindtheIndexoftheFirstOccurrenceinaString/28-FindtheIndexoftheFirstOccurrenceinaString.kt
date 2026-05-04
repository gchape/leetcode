// Last updated: 5/4/2026, 11:14:14 PM
1class Solution {
2    fun strStr(haystack: String, needle: String): Int {
3        if (needle.isEmpty()) return 0
4
5        var i = 0
6        var j = 0
7
8        while (i < haystack.length) {
9            if (haystack[i] == needle[j]) {
10                i++
11                j++
12
13                if (j == needle.length) {
14                    return i - j
15                }
16            } else {
17                i = i - j + 1
18                j = 0
19            }
20        }
21
22        return -1
23    }
24}