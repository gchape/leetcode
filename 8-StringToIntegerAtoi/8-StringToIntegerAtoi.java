// Last updated: 8/19/2026, 9:34:46 AM
class Solution {

    public int myAtoi(String s) {
        s = s.stripLeading();

        long result = 0;
        boolean isNegative = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i == 0 && (c == '-' || c == '+')) {
                isNegative = c == '-';
                continue;
            }

            if (!Character.isDigit(c)) break;

            int digit = c - '0';

            result = isNegative
                    ? result * 10 - digit
                    : result * 10 + digit;

            result = Math.clamp(result, (long) Integer.MIN_VALUE, (long) Integer.MAX_VALUE);
        }

        return (int) result;
    }
}