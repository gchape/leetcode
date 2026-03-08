class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;

        for (var n : nums) {
            if (count == 0) {
                count++;
                majority = n;
            } else if (majority == n) {
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }
}