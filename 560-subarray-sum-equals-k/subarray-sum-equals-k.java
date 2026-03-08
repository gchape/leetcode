class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        var prefix = new HashMap<Integer, Integer>() {
            {
                put(0, 1);
            }
        };

        for (var n : nums) {
            sum += n;

            if (prefix.containsKey(sum - k)) {
                count += prefix.get(sum - k);
            }

            prefix.compute(
                    sum,
                    (_, v) -> v == null ? 1 : v + 1);
        }

        return count;
    }
}