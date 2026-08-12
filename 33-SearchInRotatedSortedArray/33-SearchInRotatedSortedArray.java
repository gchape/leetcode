// Last updated: 8/12/2026, 5:54:57 PM
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // minimum must be to the right
                left = mid + 1;
            } else {
                // minimum is at mid or to the left
                right = mid;
            }
        }
        int pivot = left;
        if (nums[pivot] == target) return pivot;

        if (target > nums[pivot] && target <= nums[nums.length - 1]) {
            left = pivot;
            right = nums.length - 1;
        } else {
            left = 0;
            right = pivot - 1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}