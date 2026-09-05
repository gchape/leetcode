// Last updated: 9/5/2026, 9:10:06 PM
1class Solution {
2
3    public boolean isAnagram(String s, String t) {
4        var chars1 = s.toCharArray();
5        Arrays.sort(chars1);
6
7        var chars2 = t.toCharArray();
8        Arrays.sort(chars2);
9
10        return new String(chars1).equals(new String(chars2));
11    }
12}