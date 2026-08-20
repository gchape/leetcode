// Last updated: 8/20/2026, 11:09:16 PM
1class Solution {
2
3    public int lengthOfLongestSubstring(String s) {
4        Set<Character> chars = new HashSet<>();
5
6        int longest = 0;
7        int left = 0, right = 0;
8        while (right < s.length()) {
9            char c = s.charAt(right);
10
11            if (!chars.contains(c)) {
12                right++;
13
14                chars.add(c);
15                
16                longest = Math.max(longest, right - left);
17            } else {
18                while (chars.contains(c)) {
19                    chars.remove(s.charAt(left));
20
21                    left++;
22                }
23            }
24        }
25
26        return longest;
27    }
28}