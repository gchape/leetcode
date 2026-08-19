// Last updated: 8/19/2026, 1:47:51 PM
1class Solution {
2
3    public int strStr(String haystack, String needle) {
4        int n = haystack.length();
5        int m = needle.length();
6
7        if (m == 0)
8            return 0;
9        if (m > n)
10            return -1;
11
12        int base = 256;
13        long mod = 1_000_000_007L;
14
15        // Place value of the leading character, e.g. for length m -> base^(m-1)
16        long highOrder = 1;
17        for (int i = 0; i < m - 1; i++) {
18            highOrder = (highOrder * base) % mod;
19        }
20
21        // Hash of the needle
22        long needleHash = 0;
23        for (int i = 0; i < m; i++) {
24            needleHash = (needleHash * base + needle.charAt(i)) % mod;
25        }
26
27        // Hash of the first window in haystack
28        long windowHash = 0;
29        for (int i = 0; i < m; i++) {
30            windowHash = (windowHash * base + haystack.charAt(i)) % mod;
31        }
32
33        int last = n - m;
34
35        for (int i = 0; i <= last; i++) {
36            // Hashes match -> confirm with a real comparison (rules out collisions)
37            if (windowHash == needleHash && haystack.regionMatches(i, needle, 0, m)) {
38                return i;
39            }
40
41            if (i < last) {
42                int leavingChar = haystack.charAt(i);
43                int enteringChar = haystack.charAt(i + m);
44
45                windowHash = ((windowHash - leavingChar * highOrder) * base + enteringChar) % mod;
46                if (windowHash < 0) {
47                    windowHash += mod;
48                }
49            }
50        }
51
52        return -1;
53    }
54}