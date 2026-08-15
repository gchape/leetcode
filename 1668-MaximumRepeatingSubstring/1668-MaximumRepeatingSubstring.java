// Last updated: 8/15/2026, 9:59:40 AM
1class Solution {
2    public int maxRepeating(String sequence, String word) {
3        int count = 0;
4        String repeated = word;
5
6        while (sequence.contains(repeated)) {
7            count++;
8            repeated += word;
9        }
10
11        return count;
12    }
13}