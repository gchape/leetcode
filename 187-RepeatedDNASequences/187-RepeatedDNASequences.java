// Last updated: 8/19/2026, 2:01:48 PM
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
13        // Map each of the 4 possible DNA letters to a 2-bit code.
14        // A=00, C=01, G=10, T=11
15        int[] code = new int[26];
16        code['A' - 'A'] = 0;
17        code['C' - 'A'] = 1;
18        code['G' - 'A'] = 2;
19        code['T' - 'A'] = 3;
20
21        // A 10-character window becomes a 20-bit integer (2 bits per char).
22        // This is a PERFECT hash: every distinct 10-letter DNA sequence maps
23        // to a unique integer, so there are zero collisions - no verification needed.
24        int mask = (1 << 20) - 1; // keeps only the lowest 20 bits
25
26        int windowCode = 0;
27        for (int i = 0; i < m; i++) {
28            windowCode = (windowCode << 2) | code[s.charAt(i) - 'A'];
29        }
30
31        // seenOnce / seenTwice track state per possible 20-bit code (there are
32        // only 2^20 = ~1 million possible codes, so a plain array is fast and cheap).
33        boolean[] seenOnce = new boolean[1 << 20];
34        boolean[] seenTwice = new boolean[1 << 20];
35
36        seenOnce[windowCode] = true;
37
38        int last = n - m;
39
40        for (int i = 0; i < last; i++) {
41            int enteringChar = code[s.charAt(i + m) - 'A'];
42
43            // Shift left 2 bits (drop the oldest char automatically via mask),
44            // then add the new character's 2-bit code at the end.
45            windowCode = ((windowCode << 2) | enteringChar) & mask;
46
47            if (seenOnce[windowCode] && !seenTwice[windowCode]) {
48                seenTwice[windowCode] = true;
49                result.add(s.substring(i + 1, i + 1 + m));
50            } else {
51                seenOnce[windowCode] = true;
52            }
53        }
54
55        return result;
56    }
57}