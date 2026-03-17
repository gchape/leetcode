class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;

        Arrays.sort(nums);

        return IntStream.range(0, nums.length - 1)
                .map(i -> nums[i + 1] - nums[i])
                .max()
                .orElse(0);
    }
}