// Last updated: 8/4/2026, 7:11:10 PM
1class Solution {
2    public int longestPalindrome(String s) {
3        Set<Character> letters = new HashSet<>();
4
5        int length = 0;
6        for (var c : s.toCharArray()) {
7            if (letters.contains(c)) {
8                letters.remove(c);
9                length += 2;
10            } else {
11                letters.add(c);
12            }
13        }
14
15        if (!letters.isEmpty()) {
16            return length + 1;
17        }
18
19        return length;
20    }
21}