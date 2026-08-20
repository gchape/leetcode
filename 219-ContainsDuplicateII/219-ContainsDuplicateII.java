// Last updated: 8/20/2026, 7:57:23 PM
1class Solution {
2
3    public boolean containsNearbyDuplicate(int[] nums, int k) {
4        Map<Integer, Integer> distances = new HashMap<>();
5
6        for (int i = 0; i < nums.length; i++) {
7            int num = nums[i];
8
9            if (!distances.containsKey(num)) {
10                distances.put(num, i);
11            } else if (i - distances.get(num) <= k) {
12                return true;
13            } else {
14                distances.put(num, i);
15            }
16        }
17
18        return false;
19    }
20}