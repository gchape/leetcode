// Last updated: 9/6/2026, 10:05:33 AM
1class Solution {
2
3    public int maxSubArray(int[] nums) {
4        int maxSum = nums[0];
5        int currentSum = nums[0];
6
7        for (int i = 1; i < nums.length; i++) {
8            // If currentSum is negative, abandon it — restart from nums[i]
9            // If currentSum is still positive, keep extending
10            currentSum = Math.max(nums[i], currentSum + nums[i]);
11            maxSum = Math.max(maxSum, currentSum);
12        }
13
14        return maxSum;
15    }
16}