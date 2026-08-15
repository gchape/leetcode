// Last updated: 8/15/2026, 8:22:53 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int left = 0, right = nums.length - 1;
4
5        while (left < right) {
6            int mid = left + (right - left) / 2;
7
8            if (nums[mid] > nums[right]) {
9                left = mid + 1;
10            } else {
11                right = mid;
12            }
13        }
14
15        return nums[left];
16    }
17}