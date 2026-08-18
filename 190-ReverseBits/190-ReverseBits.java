// Last updated: 8/18/2026, 11:37:24 PM
1class Solution {
2    public int reverseBits(int n) {
3        int result = 0;
4
5        for (int i = 0; i < 32; i++) {
6            int bit = n & 1;
7
8            n >>>= 1;
9            result <<= 1;
10
11            result |= bit;
12        }
13
14        return result;
15    }
16}