// Last updated: 8/9/2026, 10:39:49 PM
1class Solution {
2    public int findPeakElement(int[] nums) {
3        int left = 0, right = nums.length - 1;
4
5        while (left <= right) {
6            int mid = left + (right - left) / 2;
7
8            // left neighbor is greater
9            if (mid > 0 && nums[mid] < nums[mid - 1]) {
10                right = mid - 1;
11            }
12            // right neighbor is greater
13            else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
14                left = mid + 1;
15            }
16            // neither neighbor is greater => peak
17            else {
18                return mid;
19            }
20        }
21
22        return -1;
23    }
24}