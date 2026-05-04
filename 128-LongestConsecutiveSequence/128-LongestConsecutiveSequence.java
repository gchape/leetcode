// Last updated: 5/4/2026, 7:18:51 PM
class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int max = 0;

        for (int n : nums) {

            if (!set.contains(n)) continue;

            set.remove(n);
            int length = 1;

            int left = n - 1;
            while (set.contains(left)) {
                set.remove(left);
                left--;
                length++;
            }

            int right = n + 1;
            while (set.contains(right)) {
                set.remove(right);
                right++;
                length++;
            }

            max = Math.max(max, length);
        }

        return max;
    }
}