// Last updated: 8/19/2026, 9:31:48 AM
class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String repeated = word;

        while (sequence.contains(repeated)) {
            count++;
            repeated += word;
        }

        return count;
    }
}