// Last updated: 8/14/2026, 6:33:26 PM
1import java.util.Arrays;
2
3class Solution {
4    public int findKthLargest(int[] nums, int k) {
5        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
6            return -1;
7        }
8
9        int target = nums.length - k;
10        return quickSelect(nums, 0, nums.length - 1, target);
11    }
12
13    private int quickSelect(int[] arr, int left, int right, int target) {
14        while (true) {
15            if (left == right) {
16                return arr[left];
17            }
18
19            int pivotValue = medianOfMedians(arr, left, right);
20
21            // Partition around pivotValue (3-way, to handle duplicates)
22            int lt = left, gt = right, i = left;
23            while (i <= gt) {
24                if (arr[i] < pivotValue) {
25                    swap(arr, lt++, i++);
26                } else if (arr[i] > pivotValue) {
27                    swap(arr, i, gt--);
28                } else {
29                    i++;
30                }
31            }
32
33            if (target < lt) {
34                right = lt - 1;
35            } else if (target > gt) {
36                left = gt + 1;
37            } else {
38                return pivotValue;
39            }
40        }
41    }
42
43    // Returns the median-of-medians value for arr[left..right]
44    private int medianOfMedians(int[] arr, int left, int right) {
45        int n = right - left + 1;
46
47        if (n <= 5) {
48            Arrays.sort(arr, left, right + 1);
49            return arr[left + n / 2];
50        }
51
52        int numGroups = (n + 4) / 5;
53        int[] medians = new int[numGroups];
54
55        for (int g = 0; g < numGroups; g++) {
56            int groupLeft = left + g * 5;
57            int groupRight = Math.min(groupLeft + 4, right);
58            Arrays.sort(arr, groupLeft, groupRight + 1);
59            int mid = groupLeft + (groupRight - groupLeft) / 2;
60            medians[g] = arr[mid];
61        }
62
63        // Recursively find the median of the medians array
64        return quickSelect(medians, 0, medians.length - 1, medians.length / 2);
65    }
66
67    private void swap(int[] arr, int i, int j) {
68        int temp = arr[i];
69        arr[i] = arr[j];
70        arr[j] = temp;
71    }
72}