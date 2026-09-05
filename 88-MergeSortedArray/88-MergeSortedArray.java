// Last updated: 9/5/2026, 8:36:15 PM
1class Solution {
2
3    public void merge(int[] nums1, int m, int[] nums2, int n) {
4        int x = m - 1, y = n - 1, z = m + n - 1;
5
6        while (y >= 0) {
7            if (x >= 0 && nums1[x] > nums2[y]) {
8                nums1[z] = nums1[x];
9                x--;
10            } else {
11                nums1[z] = nums2[y];
12                y--;
13            }
14            z--;
15        }
16    }
17}