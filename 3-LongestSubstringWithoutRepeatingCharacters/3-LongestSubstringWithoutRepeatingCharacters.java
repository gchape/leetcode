// Last updated: 9/5/2026, 10:01:47 PM
1class Solution {
2
3    public int lengthOfLongestSubstring(String s) {
4        int left = 0, right = 0;
5        var seen = new HashSet<Character>();
6        int longestSubstring = 0;
7
8        while (right < s.length()) {
9            char c = s.charAt(right);
10
11            if (seen.add(c)) {
12                right++;
13                longestSubstring = Math.max(longestSubstring, right - left);
14            } else {
15                seen.remove(s.charAt(left));
16                left++;
17            }
18        }
19
20        return longestSubstring;
21    }
22}