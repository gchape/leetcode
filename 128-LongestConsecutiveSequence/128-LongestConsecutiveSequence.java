// Last updated: 8/20/2026, 11:24:55 PM
1class Solution {
2    
3    public int longestConsecutive(int[] nums) {
4        Set<Integer> set = new HashSet<>();
5
6        for (int num : nums) {
7            set.add(num);
8        }
9
10        int longest = 0;
11
12        for (int num : set) {
13            // Only start counting if num is the beginning
14            if (!set.contains(num - 1)) {
15                int current = num;
16                int length = 1;
17
18                while (set.contains(current + 1)) {
19                    current++;
20                    length++;
21                }
22
23                longest = Math.max(longest, length);
24            }
25        }
26
27        return longest;
28    }
29}