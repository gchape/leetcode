// Last updated: 8/4/2026, 8:09:15 PM
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
13        int from = 0;
14
15        while (idx < s.length()) {
16
17            // Down
18            for (int i = from; i < numRows && idx < s.length(); i++) {
19                rows[i].append(s.charAt(idx++));
20            }
21
22            // Up (skip first and last rows)
23            for (int i = numRows - 2; i > 0 && idx < s.length(); i--) {
24                rows[i].append(s.charAt(idx++));
25            }
26
27        }
28
29        StringBuilder result = new StringBuilder();
30        for (StringBuilder row : rows) {
31            result.append(row);
32        }
33
34        return result.toString();
35    }
36}