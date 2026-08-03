// Last updated: 8/3/2026, 5:15:30 PM
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n = nums.length;
4
5        for (int i = 0; i < n; i++) {
6            while (nums[i] > 0 &&
7                    nums[i] <= n &&
8                    nums[i] != nums[nums[i] - 1]) {
9
10                int correct = nums[i] - 1;
11
12                int temp = nums[i];
13                nums[i] = nums[correct];
14                nums[correct] = temp;
15            }
16        }
17
18        for (int i = 0; i < n; i++) {
19            if (nums[i] != i + 1) {
20                return i + 1;
21            }
22        }
23
24        return n + 1;
25    }
26}