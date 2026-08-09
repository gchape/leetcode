// Last updated: 8/9/2026, 10:34:30 PM
1class Solution {
2    public int findPeakElement(int[] nums) {
3        if (nums.length == 1) return 0;
4
5        int left = 0, right = nums.length - 1;
6
7        while (left <= right) {
8            int mid = left + (right - left) / 2;
9
10            if (mid == 0) {
11                if (nums[0] > nums[1]) {
12                    return 0;
13                }
14                left = mid + 1;
15                continue;
16            }
17
18            if (mid == nums.length - 1) {
19                if (nums[nums.length - 1] > nums[nums.length - 2]) {
20                    return nums.length - 1;
21                }
22                right = mid - 1;
23                continue;
24            }
25
26            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
27                return mid;
28            }
29
30            if (nums[mid] < nums[mid + 1]) {
31                left = mid + 1;
32            } else {
33                right = mid - 1;
34            }
35        }
36
37        return -1;
38    }
39}