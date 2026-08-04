// Last updated: 8/4/2026, 8:09:41 PM
1class Solution {
2    public String convert(String s, int numRows) {
3        if (numRows == 1 || s.length() <= numRows) {
4            return s;
5        }
6
7        StringBuilder[] rows = new StringBuilder[numRows];
8        for (int i = 0; i < numRows; i++) {
9            rows[i] = new StringBuilder();
10        }
11
12        int idx = 0;
13
14        while (idx < s.length()) {
15
16            // Down
17            for (int i = 0; i < numRows && idx < s.length(); i++) {
18                rows[i].append(s.charAt(idx++));
19            }
20
21            // Up (skip first and last rows)
22            for (int i = numRows - 2; i > 0 && idx < s.length(); i--) {
23                rows[i].append(s.charAt(idx++));
24            }
25
26        }
27
28        StringBuilder result = new StringBuilder();
29        for (StringBuilder row : rows) {
30            result.append(row);
31        }
32
33        return result.toString();
34    }
35}