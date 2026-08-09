// Last updated: 8/9/2026, 2:39:07 PM
1class Solution {
2    public int mySqrt(int x) {
3        int i = 0;
4        for (; (long) (i + 1) * (i + 1) <= x; i++) {
5        }
6
7        return i;
8    }
9}