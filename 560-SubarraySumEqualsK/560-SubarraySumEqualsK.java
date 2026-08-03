// Last updated: 8/3/2026, 4:48:19 PM
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        Arrays.parallelPrefix(nums, Integer::sum);
4
5        int count = 0;
6        for (int i = 0; i < nums.length; i++) {
7            if (nums[i] == k) {
8                count++;
9            }
10            for (int j = 0; j < i; j++) {
11                if (nums[i] - nums[j] == k) {
12                    count++;
13                }
14            }
15        }
16
17        return count;
18    }
19}