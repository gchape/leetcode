// Last updated: 9/6/2026, 10:34:11 AM
1class Solution {
2
3    public List<List<Integer>> threeSum(int[] nums) {
4        Arrays.sort(nums);
5        List<List<Integer>> result = new ArrayList<>();
6
7        for (int i = 0; i < nums.length - 2; i++) {
8            if (i > 0 && nums[i] == nums[i - 1])
9                continue; // skip duplicate 'i' values
10
11            int left = i + 1, right = nums.length - 1;
12            int target = -nums[i];
13
14            while (left < right) {
15                int sum = nums[left] + nums[right];
16                if (sum == target) {
17                    result.add(List.of(nums[i], nums[left], nums[right]));
18                    left++;
19                    right--;
20                    while (left < right && nums[left] == nums[left - 1])
21                        left++; // skip duplicate 'left' values
22                    while (left < right && nums[right] == nums[right + 1])
23                        right--; // skip duplicate 'right' values
24                } else if (sum < target) {
25                    left++;
26                } else {
27                    right--;
28                }
29            }
30        }
31
32        return result;
33    }
34}