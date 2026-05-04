// Last updated: 5/4/2026, 7:19:07 PM
class Solution {
    public boolean isPalindrome(int x) {
        var chars = (x + "").toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}