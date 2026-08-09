// Last updated: 8/9/2026, 7:17:46 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int left = 0, right = nums.length - 1;
4
5while (left < right) {
6    int mid = left + (right - left) / 2;
7
8    if (nums[mid] > nums[right]) {
9        left = mid + 1;
10    } else {
11        right = mid;
12    }
13}
14
15return nums[left];
16    }
17}