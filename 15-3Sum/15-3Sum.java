// Last updated: 8/2/2026, 11:14:01 AM
1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        List<List<Integer>> result = new ArrayList<>();
4
5        Arrays.sort(nums);
6
7        for (int i = 0; i < nums.length - 2; i++) {
8
9            // Skip duplicate first elements
10            if (i > 0 && nums[i] == nums[i - 1]) {
11                continue;
12            }
13
14            int left = i + 1;
15            int right = nums.length - 1;
16
17            while (left < right) {
18                int sum = nums[i] + nums[left] + nums[right];
19
20                if (sum == 0) {
21                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
22
23                    // Skip duplicate left values
24                    while (left < right && nums[left] == nums[left + 1]) {
25                        left++;
26                    }
27
28                    // Skip duplicate right values
29                    while (left < right && nums[right] == nums[right - 1]) {
30                        right--;
31                    }
32
33                    left++;
34                    right--;
35
36                } else if (sum < 0) {
37                    left++; // Need a larger sum
38                } else {
39                    right--; // Need a smaller sum
40                }
41            }
42        }
43
44        return result;
45    }
46}