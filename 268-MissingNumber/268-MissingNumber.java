// Last updated: 8/15/2026, 9:21:06 PM
1class Solution {
2    public int missingNumber(int[] nums) {
3        int xor = nums.length;
4        
5        for (int i = 0; i < nums.length; i++) {
6            xor ^= i ^ nums[i];
7        }
8        
9        return xor;
10    }
11}