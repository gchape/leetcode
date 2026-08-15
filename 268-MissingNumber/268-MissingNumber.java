// Last updated: 8/15/2026, 9:18:02 PM
1class Solution {
2    public int missingNumber(int[] nums) {
3        var bitSet = new java.util.BitSet(nums.length);
4
5        for (var num : nums) {
6            bitSet.set(num);
7        }
8
9        return bitSet.nextClearBit(0);
10    }
11}