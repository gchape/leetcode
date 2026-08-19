// Last updated: 8/19/2026, 9:20:21 AM
1class Solution {
2
3    public List<String> letterCombinations(String digits) {
4        List<String> result = new ArrayList<>();
5        addAllCombinations(result, new StringBuilder(), digits, 0);
6        return result;
7    }
8
9    private void addAllCombinations(
10            List<String> result,
11            StringBuilder sb,
12            String digits,
13            int i) {
14
15        if (i >= digits.length()) {
16            result.add(sb.toString());
17            return;
18        }
19
20        int digit = digits.charAt(i) - '0';
21        int start = (digit - 2) * 3;
22
23        if (digit > 7)
24            start++;
25
26        int end = start + (digit == 7 || digit == 9 ? 4 : 3);
27
28        for (; start < end; start++) {
29            sb.append((char) ('a' + start));
30
31            addAllCombinations(result, sb, digits, i + 1);
32
33            sb.deleteCharAt(sb.length() - 1);
34        }
35    }
36}