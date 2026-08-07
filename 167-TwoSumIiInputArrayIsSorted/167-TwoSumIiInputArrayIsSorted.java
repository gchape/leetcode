// Last updated: 8/7/2026, 11:13:34 AM
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0, tail = numbers.length - 1;

        while (head < tail) {
            int sum = numbers[head] + numbers[tail];

            if (sum < target) {
                head++;
            } else if (sum > target) {
                tail--;
            } else {
                return new int[] { head + 1, tail + 1 };
            }
        }

        return null;
    }
}