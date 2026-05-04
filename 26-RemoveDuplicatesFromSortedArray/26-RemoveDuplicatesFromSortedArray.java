// Last updated: 5/4/2026, 7:19:01 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j - 1] != nums[j]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }
}