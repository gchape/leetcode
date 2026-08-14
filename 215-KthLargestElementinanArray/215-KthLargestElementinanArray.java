// Last updated: 8/14/2026, 6:31:50 PM
1import java.util.concurrent.ThreadLocalRandom;
2
3class Solution {
4    public int findKthLargest(int[] nums, int k) {
5        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
6            return -1;
7        }
8
9        int target = nums.length - k;
10        int left = 0, right = nums.length - 1;
11
12        while (left < right) {
13            int pivotIndex = left + ThreadLocalRandom.current().nextInt(right - left + 1);
14            int pivotValue = nums[pivotIndex];
15
16            int lt = left, gt = right, i = left;
17            // Invariant: [left, lt) < pivot, [lt, i) == pivot, (gt, right] > pivot
18            while (i <= gt) {
19                if (nums[i] < pivotValue) {
20                    swap(nums, lt++, i++);
21                } else if (nums[i] > pivotValue) {
22                    swap(nums, i, gt--);
23                } else {
24                    i++;
25                }
26            }
27
28            if (target < lt) {
29                right = lt - 1;
30            } else if (target > gt) {
31                left = gt + 1;
32            } else {
33                // target falls within the equal-to-pivot block — done
34                return nums[target];
35            }
36        }
37
38        return nums[left];
39    }
40
41    private void swap(int[] arr, int i, int j) {
42        int temp = arr[i];
43        arr[i] = arr[j];
44        arr[j] = temp;
45    }
46}