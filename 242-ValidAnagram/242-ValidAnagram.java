// Last updated: 9/5/2026, 9:11:36 PM
1class Solution {
2
3    public boolean isAnagram(String s, String t) {
4        if (s.length() != t.length())
5            return false;
6        int[] counts = new int[26];
7        for (int i = 0; i < s.length(); i++) {
8            counts[s.charAt(i) - 'a']++;
9            counts[t.charAt(i) - 'a']--;
10        }
11        for (int c : counts)
12            if (c != 0)
13                return false;
14        return true;
15    }
16}