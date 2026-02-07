class Solution {
    public int majorityElement(int[] nums) {
        int el = -1;
        int cnt = 1;

        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                el = nums[i];
                cnt++;
            }
            
            if (el == nums[i]) {
                cnt++;
            }

            if (el != nums[i]) {
                cnt--;
            }

            if (cnt == 0) {
                cnt++;
                el = nums[i];
            }
        }

        return el;
    }
}