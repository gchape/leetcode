// Last updated: 8/2/2026, 8:03:33 AM
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        var map = new HashMap<Integer, Integer>();
4        for (int i = 0; i < nums.length; i++) {
5            map.put(nums[i], i);
6        }
7
8        for (int i = 0; i < nums.length; i++) {
9            var j = map.get(target - nums[i]);
10            if (j != null && j != i) {
11                return new int[] { i, j };
12            }
13        }
14
15        return null;
16    }
17}