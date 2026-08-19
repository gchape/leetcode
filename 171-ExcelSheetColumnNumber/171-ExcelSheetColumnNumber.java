// Last updated: 8/19/2026, 9:33:50 AM
class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            var c = columnTitle.charAt(i);
            result = result * 26 + (c - 'A' + 1);
        }

        return result;
    }
}