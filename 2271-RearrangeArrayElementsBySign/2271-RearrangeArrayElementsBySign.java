// Last updated: 5/4/2026, 7:18:20 PM
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0, neg = 1;
        int[] result = new int[nums.length];

        for (var n : nums) {
            if (n > 0) {
                result[pos] = n;

                pos += 2;
            } else {
                result[neg] = n;

                neg += 2;
            }
        }

        return result;
    }
}