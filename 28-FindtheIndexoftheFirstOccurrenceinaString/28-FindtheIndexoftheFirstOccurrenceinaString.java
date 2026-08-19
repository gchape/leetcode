// Last updated: 8/19/2026, 1:47:41 PM
1class Solution {
2
3    public int strStr(String haystack, String needle) {
4        int n = haystack.length();
5        int m = needle.length();
6
7        if (m == 0) return 0;
8        if (m > n) return -1;
9
10        int base = 256;
11        long mod = 1_000_000_007L;
12
13        // Place value of the leading character, e.g. for length m -> base^(m-1)
14        long highOrder = 1;
15        for (int i = 0; i < m - 1; i++) {
16            highOrder = (highOrder * base) % mod;
17        }
18
19        // Hash of the needle
20        long needleHash = 0;
21        for (int i = 0; i < m; i++) {
22            needleHash = (needleHash * base + needle.charAt(i)) % mod;
23        }
24
25        // Hash of the first window in haystack
26        long windowHash = 0;
27        for (int i = 0; i < m; i++) {
28            windowHash = (windowHash * base + haystack.charAt(i)) % mod;
29        }
30
31        int last = n - m;
32
33        for (int i = 0; i <= last; i++) {
34            // Hashes match -> confirm with a real comparison (rules out collisions)
35            if (windowHash == needleHash && haystack.regionMatches(i, needle, 0, m)) {
36                return i;
37            }
38
39            if (i < last) {
40                int leavingChar = haystack.charAt(i);
41                int enteringChar = haystack.charAt(i + m);
42
43                windowHash = ((windowHash - leavingChar * highOrder) * base + enteringChar) % mod;
44                if (windowHash < 0) {
45                    windowHash += mod;
46                }
47            }
48        }
49
50        return -1;
51    }
52}