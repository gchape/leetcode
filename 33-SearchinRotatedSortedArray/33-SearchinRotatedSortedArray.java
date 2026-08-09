// Last updated: 8/9/2026, 7:01:23 PM
1class Solution {
2    public int search(int[] nums, int target) {
3        int left = 0, right = nums.length - 1;
4
5        while (left < right) {
6            int mid = left + (right - left) / 2;
7
8            if (nums[mid] > nums[right]) {
9                // minimum must be to the right
10                left = mid + 1;
11            } else {
12                // minimum is at mid or to the left
13                right = mid;
14            }
15        }
16        int pivot = left;
17        if (nums[pivot] == target) return pivot;
18
19        if (target > nums[pivot] && target <= nums[nums.length - 1]) {
20            left = pivot;
21            right = nums.length - 1;
22        } else {
23            left = 0;
24            right = pivot - 1;
25        }
26
27        while (left <= right) {
28            int mid = left + (right - left) / 2;
29
30            if (nums[mid] == target) {
31                return mid;
32            }
33
34            if (nums[mid] < target) {
35                left = mid + 1;
36            } else {
37                right = mid - 1;
38            }
39        }
40
41        return -1;
42    }
43}