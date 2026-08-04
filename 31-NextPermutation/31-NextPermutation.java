// Last updated: 8/4/2026, 11:34:58 AM
1class Solution {
2    public void nextPermutation(int[] nums) {
3        int pivot = -1;
4
5        for (int i = nums.length - 1; i > 0; i--) {
6            if (nums[i - 1] < nums[i]) {
7                pivot = i - 1;
8                break;
9            }
10        }
11
12        if (pivot == -1) {
13            reverse(0, nums.length, nums);
14            return;
15        }
16
17        for (int i = nums.length - 1; i > pivot; i--) {
18            if (nums[i] > nums[pivot]) {
19                int tmp = nums[i];
20                nums[i] = nums[pivot];
21                nums[pivot] = tmp;
22                break;
23            }
24        }
25
26        reverse(pivot + 1, nums.length, nums);
27    }
28
29    private void reverse(int from, int to, int[] arr) {
30        for (int i = 0; i < (to - from) / 2; i++) {
31            int tmp = arr[from + i];
32            arr[from + i] = arr[to - i - 1];
33            arr[to - i - 1] = tmp;
34        }
35    }
36}