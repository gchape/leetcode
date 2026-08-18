// Last updated: 8/18/2026, 11:52:31 PM
1class Solution {
2    public String addBinary(String a, String b) {
3        String first, second;
4
5        if (a.length() >= b.length()) {
6            first = b;
7            second = a;
8        } else {
9            first = a;
10            second = b;
11        }
12
13        int carry = 0;
14        StringBuilder result = new StringBuilder();
15
16        // Add while both strings have digits
17        for (int i = 0; i < first.length(); i++) {
18            int c1 = first.charAt(first.length() - i - 1) - '0';
19            int c2 = second.charAt(second.length() - i - 1) - '0';
20
21            int sum = c1 + c2 + carry;
22
23            result.append(sum % 2);
24            carry = sum / 2;
25        }
26
27        // Process remaining digits of second
28        for (int i = first.length(); i < second.length(); i++) {
29            int c = second.charAt(second.length() - i - 1) - '0';
30
31            int sum = c + carry;
32
33            result.append(sum % 2);
34            carry = sum / 2;
35        }
36
37        if (carry != 0)
38            result.append('1');
39
40        return result.reverse().toString();
41    }
42}