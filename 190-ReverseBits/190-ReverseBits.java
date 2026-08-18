// Last updated: 8/18/2026, 11:37:59 PM
1class Solution {
2    
3    public int reverseBits(int n) {
4        int result = 0;
5
6        for (int i = 0; i < 32; i++) {
7            int bit = n & 1;
8
9            n >>>= 1;
10            result <<= 1;
11
12            result |= bit;
13        }
14
15        return result;
16    }
17}