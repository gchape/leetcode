// Last updated: 8/19/2026, 2:03:36 PM
1import java.util.*;
2
3class Solution {
4
5    public List<String> findRepeatedDnaSequences(String s) {
6        List<String> result = new ArrayList<>();
7
8        int n = s.length();
9        int m = 10;
10
11        if (n < m) return result;
12
13        Set<String> seen = new HashSet<>();
14        Set<String> added = new HashSet<>();
15
16        for (int i = 0; i <= n - m; i++) {
17            String window = s.substring(i, i + m);
18
19            // Java's String.equals() / hashCode() already does the heavy lifting -
20            // no manual hashing needed at all.
21            if (!seen.add(window)) {
22                // add() returns false if it was already in the set -> it's a repeat
23                if (added.add(window)) {
24                    result.add(window);
25                }
26            }
27        }
28
29        return result;
30    }
31}