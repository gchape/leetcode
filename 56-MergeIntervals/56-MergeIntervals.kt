// Last updated: 5/4/2026, 8:38:50 PM
1class Solution {
2    fun strStr(haystack: String, needle: String): Int {
3        for (i in 0..haystack.length - needle.length) {
4            var match = true
5
6            for (j in needle.indices) {
7                if (haystack[i + j] != needle[j]) {
8                    match = false
9                    break
10                }
11            }
12
13            if (match) return i
14        }
15
16        return -1
17    }
18}