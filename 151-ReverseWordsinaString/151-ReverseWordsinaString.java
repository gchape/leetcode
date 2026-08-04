// Last updated: 8/4/2026, 10:27:37 PM
1class Solution {
2    public String reverseWords(String s) {
3        String[] words = s.trim().split("\\s+");
4
5        Collections.reverse(Arrays.asList(words));
6
7        return String.join(" ", words);
8    }
9}