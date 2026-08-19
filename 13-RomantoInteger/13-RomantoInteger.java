// Last updated: 8/19/2026, 8:46:35 AM
1class Solution {
2
3    public int romanToInt(String s) {
4        var ct = Map.<Character, Integer>of(
5            'I', 1,
6            'V', 5,
7            'X', 10,
8            'L', 50,
9            'C', 100,
10            'D', 500,
11            'M', 1000
12        );
13
14        int result = 0;
15        for (int i = 0; i < s.length() - 1; i++) {
16            int curr = ct.get(s.charAt(i));
17            int next = ct.get(s.charAt(i + 1));
18
19            if (curr < next) {
20                result -= curr;
21            } else {
22                result += curr;
23            }
24        }
25
26        return (result += ct.get(s.charAt(s.length() - 1)));
27    }
28}