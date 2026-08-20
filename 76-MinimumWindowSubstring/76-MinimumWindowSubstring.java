// Last updated: 8/20/2026, 11:36:28 PM
1class Solution {
2    
3    public String minWindow(String s, String t) {
4        int[] required = new int[128];
5        int[] window = new int[128];
6
7        for (char c : t.toCharArray()) {
8            required[c]++;
9        }
10
11        int requiredDistinct = 0;
12
13        for (int count : required) {
14            if (count > 0) {
15                requiredDistinct++;
16            }
17        }
18
19        int formed = 0;
20
21        int left = 0;
22        int bestLeft = 0;
23        int bestLength = Integer.MAX_VALUE;
24
25        for (int right = 0; right < s.length(); right++) {
26            char c = s.charAt(right);
27            window[c]++;
28
29            if (required[c] > 0 && window[c] == required[c]) {
30                formed++;
31            }
32
33            while (formed == requiredDistinct) {
34                int length = right - left + 1;
35
36                if (length < bestLength) {
37                    bestLength = length;
38                    bestLeft = left;
39                }
40
41                char leftChar = s.charAt(left);
42                window[leftChar]--;
43
44                if (required[leftChar] > 0 &&
45                    window[leftChar] < required[leftChar]) {
46                    formed--;
47                }
48
49                left++;
50            }
51        }
52
53        return bestLength == Integer.MAX_VALUE
54                ? ""
55                : s.substring(bestLeft, bestLeft + bestLength);
56    }
57}