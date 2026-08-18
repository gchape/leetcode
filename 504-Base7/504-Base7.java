// Last updated: 8/18/2026, 11:56:02 PM
1class Solution {
2
3    public String convertToBase7(int num) {
4        if (num == 0)
5            return "0";
6
7        boolean negative = num < 0;
8        num = Math.abs(num);
9
10        StringBuilder result = new StringBuilder();
11
12        while (num > 0) {
13            result.append(num % 7);
14            num /= 7;
15        }
16
17        if (negative)
18            result.append('-');
19
20        return result.reverse().toString();
21    }
22}