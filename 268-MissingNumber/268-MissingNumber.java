// Last updated: 5/4/2026, 7:18:38 PM
class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0, xor2 = 0;
        
        for (var n : nums) {
            xor1 ^= n;
        }

        for (int i = 0; i <= nums.length; i++) {
            xor2 ^= i;
        }

        return xor1 ^ xor2;
    }
}