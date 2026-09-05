// Last updated: 9/5/2026, 10:02:12 PM
1class Solution {
2
3    public int lengthOfLongestSubstring(String s) {
4        int left = 0, right = 0, longestSubstring = 0;
5        var seen = new HashSet<Character>();
6
7        while (right < s.length()) {
8            char c = s.charAt(right);
9
10            if (seen.add(c)) {
11                right++;
12                longestSubstring = Math.max(longestSubstring, right - left);
13            } else {
14                seen.remove(s.charAt(left));
15                left++;
16            }
17        }
18
19        return longestSubstring;
20    }
21}