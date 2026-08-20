// Last updated: 8/20/2026, 7:58:32 PM
1class Solution {
2
3    public boolean containsNearbyDuplicate(int[] nums, int k) {
4        Map<Integer, Integer> lastSeen = new HashMap<>();
5
6        for (int i = 0; i < nums.length; i++) {
7            Integer previous = lastSeen.get(nums[i]);
8
9            if (previous != null && i - previous <= k) {
10                return true;
11            }
12
13            lastSeen.put(nums[i], i);
14        }
15
16        return false;
17    }
18}