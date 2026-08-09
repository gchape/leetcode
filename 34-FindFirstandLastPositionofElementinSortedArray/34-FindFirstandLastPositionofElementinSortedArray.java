// Last updated: 8/9/2026, 4:55:35 PM
1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        int first = findFirst(nums, target);
4        int last = findLast(nums, target);
5
6        return new int[] { first, last };
7    }
8
9    private int findFirst(int[] nums, int target) {
10        int left = 0, right = nums.length - 1;
11        int result = -1;
12
13        while (left <= right) {
14            int mid = left + (right - left) / 2;
15
16            if (nums[mid] >= target) {
17                if (nums[mid] == target)
18                    result = mid;
19
20                right = mid - 1;
21            } else {
22                left = mid + 1;
23            }
24        }
25
26        return result;
27    }
28
29    private int findLast(int[] nums, int target) {
30        int left = 0, right = nums.length - 1;
31        int result = -1;
32
33        while (left <= right) {
34            int mid = left + (right - left) / 2;
35
36            if (nums[mid] <= target) {
37                if (nums[mid] == target)
38                    result = mid;
39
40                left = mid + 1;
41            } else {
42                right = mid - 1;
43            }
44        }
45
46        return result;
47    }
48}