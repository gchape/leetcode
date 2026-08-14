// Last updated: 8/14/2026, 8:28:08 PM
import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }

        int target = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, target);
    }

    private int quickSelect(int[] arr, int left, int right, int target) {
        while (true) {
            if (left == right) {
                return arr[left];
            }

            int pivotValue = medianOfMedians(arr, left, right);

            // Partition around pivotValue (3-way, to handle duplicates)
            int lt = left, gt = right, i = left;
            while (i <= gt) {
                if (arr[i] < pivotValue) {
                    swap(arr, lt++, i++);
                } else if (arr[i] > pivotValue) {
                    swap(arr, i, gt--);
                } else {
                    i++;
                }
            }

            if (target < lt) {
                right = lt - 1;
            } else if (target > gt) {
                left = gt + 1;
            } else {
                return pivotValue;
            }
        }
    }

    // Returns the median-of-medians value for arr[left..right]
    private int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;

        if (n <= 5) {
            Arrays.sort(arr, left, right + 1);
            return arr[left + n / 2];
        }

        int numGroups = (n + 4) / 5;
        int[] medians = new int[numGroups];

        for (int g = 0; g < numGroups; g++) {
            int groupLeft = left + g * 5;
            int groupRight = Math.min(groupLeft + 4, right);
            Arrays.sort(arr, groupLeft, groupRight + 1);
            int mid = groupLeft + (groupRight - groupLeft) / 2;
            medians[g] = arr[mid];
        }

        // Recursively find the median of the medians array
        return quickSelect(medians, 0, medians.length - 1, medians.length / 2);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}