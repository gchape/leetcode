// Last updated: 8/12/2026, 5:54:29 PM
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

while (left < right) {
    int mid = left + (right - left) / 2;

    if (nums[mid] > nums[right]) {
        left = mid + 1;
    } else {
        right = mid;
    }
}

return nums[left];
    }
}