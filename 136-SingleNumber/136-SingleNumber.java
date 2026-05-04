// Last updated: 5/4/2026, 7:18:50 PM
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;

        for (var n : nums) {
            xor ^= n;
        }

        return xor;
    }
}