// Last updated: 9/6/2026, 10:28:09 AM
1class Solution {
2
3    public List<List<Integer>> threeSum(int[] nums) {
4        Set<List<Integer>> uniqueTriplets = new HashSet<>();
5
6        for (int i = 0; i < nums.length; i++) {
7            int target = -nums[i];
8            Set<Integer> seen = new HashSet<>();
9
10            for (int j = i + 1; j < nums.length; j++) {
11                int complement = target - nums[j];
12
13                if (seen.contains(complement)) {
14                    List<Integer> triplet = new ArrayList<>(List.of(nums[i], complement, nums[j]));
15                    Collections.sort(triplet);
16                    uniqueTriplets.add(triplet);
17                }
18
19                seen.add(nums[j]);
20            }
21        }
22
23        return new ArrayList<>(uniqueTriplets);
24    }
25}