// Last updated: 8/5/2026, 11:47:14 PM
1class Solution {
2    public boolean containsDuplicate(int[] nums) {
3        var set = new java.util.HashSet<Integer>();
4
5        for (var n : nums) {
6            if (set.contains(n)) {
7                return true;
8            } else {
9                set.add(n);
10            }
11        }
12
13        return false;
14    }
15}