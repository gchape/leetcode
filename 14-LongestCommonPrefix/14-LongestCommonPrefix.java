// Last updated: 9/5/2026, 7:28:16 PM
1class Solution {
2
3    public String longestCommonPrefix(String[] strs) {
4        var s = strs[0];
5        var prefix = new StringBuilder();
6        
7        for (int i = 0; i < s.length(); i++) {
8            boolean stop = false;
9
10            for (var str : strs) {
11                if (i >= str.length() || str.charAt(i) != s.charAt(i)) {
12                    stop = true;
13                    break;
14                }
15            }
16
17            if (stop) break;
18            else prefix.append(s.charAt(i));
19        }
20
21        return prefix.toString();
22    }
23}