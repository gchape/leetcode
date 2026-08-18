// Last updated: 8/18/2026, 9:18:54 PM
1class Solution {
2
3    public int myAtoi(String s) {
4        s = s.stripLeading();
5
6        long result = 0;
7        boolean isNegative = false;
8
9        for (int i = 0; i < s.length(); i++) {
10            char c = s.charAt(i);
11
12            if (i == 0 && (c == '-' || c == '+')) {
13                isNegative = c == '-';
14                continue;
15            }
16
17            if (!Character.isDigit(c)) break;
18
19            int digit = c - '0';
20
21            result = isNegative
22                    ? result * 10 - digit
23                    : result * 10 + digit;
24
25            result = Math.clamp(result, (long) Integer.MIN_VALUE, (long) Integer.MAX_VALUE);
26        }
27
28        return (int) result;
29    }
30}