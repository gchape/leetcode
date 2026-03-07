class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE, count = 0;

        for (var n : nums) {
            if (n == 1) {
                count++;
            } else {
                max = Math.max(
                    max, 
                    count
                    );

                count = 0;
            }
        }

        return Math.max(max, count);
    }
}