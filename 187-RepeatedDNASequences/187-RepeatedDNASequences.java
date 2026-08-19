// Last updated: 8/19/2026, 2:00:36 PM
1import java.util.*;
2
3class Solution {
4
5    public List<String> findRepeatedDnaSequences(String s) {
6        List<String> result = new ArrayList<>();
7
8        int n = s.length();
9        int m = 10; // we're always looking at windows of exactly 10 characters
10
11        if (n < m) return result;
12
13        int base = 256;
14        long mod = 1_000_000_007L;
15
16        // Place value of the leading character: base^(m-1)
17        long highOrder = 1;
18        for (int i = 0; i < m - 1; i++) {
19            highOrder = (highOrder * base) % mod;
20        }
21
22        // Hash of the very first 10-character window
23        long windowHash = 0;
24        for (int i = 0; i < m; i++) {
25            windowHash = (windowHash * base + s.charAt(i)) % mod;
26        }
27
28        // Maps a hash -> the actual substrings we've seen with that hash.
29        // (A list, not just a count, so we can verify and catch collisions.)
30        Map<Long, List<String>> seen = new HashMap<>();
31
32        // Track which sequences we've already added to the result,
33        // so a sequence appearing 3+ times doesn't get added more than once.
34        Set<String> added = new HashSet<>();
35
36        String firstWindow = s.substring(0, m);
37        seen.computeIfAbsent(windowHash, k -> new ArrayList<>()).add(firstWindow);
38
39        int last = n - m;
40
41        for (int i = 0; i < last; i++) {
42            // Slide the window forward by one character
43            int leavingChar = s.charAt(i);
44            int enteringChar = s.charAt(i + m);
45
46            windowHash = ((windowHash - leavingChar * highOrder) * base + enteringChar) % mod;
47            if (windowHash < 0) {
48                windowHash += mod;
49            }
50
51            String currentWindow = s.substring(i + 1, i + 1 + m);
52            List<String> bucket = seen.computeIfAbsent(windowHash, k -> new ArrayList<>());
53
54            // Real substring check: is currentWindow genuinely already in this bucket?
55            // (Not just "does the hash match" - the hash could collide with a different string.)
56            if (bucket.contains(currentWindow)) {
57                if (added.add(currentWindow)) {
58                    result.add(currentWindow);
59                }
60            } else {
61                bucket.add(currentWindow);
62            }
63        }
64
65        return result;
66    }
67}