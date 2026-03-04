class Solution {
    public void moveZeroes(int[] nums) {
        int z = -1;

        // Find first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                z = i;
                break;
            }
        }

        if (z == -1) return;

        for (int i = z + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[z] = nums[i];
                nums[i] = 0;
                z++;
            }
        }
    }
}