// Last updated: 8/19/2026, 1:48:11 PM
1class Solution {
2
3    public int strStr(String haystack, String needle) {
4        int last = haystack.length() - needle.length();
5
6        for (int i = 0; i <= last; i++) {
7            boolean found = true;
8
9            for (int j = 0; j < needle.length(); j++) {
10                if (haystack.charAt(i + j) != needle.charAt(j)) {
11                    found = false;
12                    break;
13                }
14            }
15
16            if (found)
17                return i;
18        }
19
20        return -1;
21    }
22}