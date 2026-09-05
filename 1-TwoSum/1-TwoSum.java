// Last updated: 9/5/2026, 8:49:03 PM
1class Solution {
2
3    public int[] twoSum(int[] nums, int target) {
4        Map<Integer, Integer> m = HashMap.newHashMap(nums.length);
5
6        for (int i = 0; i < nums.length; i++) {
7            m.put(nums[i], i);
8        }
9
10        for (int i = 0; i < nums.length; i++) {
11            Integer j = m.get(target - nums[i]);
12
13            if (j != null && j != i) {
14                return new int[] { i, m.get(target - nums[i]) };
15            }
16        }
17
18        return null;
19    }
20}