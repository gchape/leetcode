class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;

        for (int n : nums) {
            if (n == 0) {
                zeros++;
            } else if (n == 1) {
                ones++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeros != 0) {
                nums[i] = 0;
                zeros--;
            } else if (ones != 0) {
                nums[i] = 1;
                ones--;
            } else {
                nums[i] = 2;
            }
        }
    }
}