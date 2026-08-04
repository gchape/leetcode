// Last updated: 8/4/2026, 9:45:03 PM
1class Solution {
2    public String addStrings(String num1, String num2) {
3        int i = num1.length() - 1;
4        int j = num2.length() - 1;
5        int carry = 0;
6
7        StringBuilder result = new StringBuilder();
8
9        while (i >= 0 || j >= 0 || carry > 0) {
10            int d1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
11            int d2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
12
13            int sum = d1 + d2 + carry;
14            result.append(sum % 10);
15            carry = sum / 10;
16
17            i--;
18            j--;
19        }
20
21        return result.reverse().toString();
22    }
23}