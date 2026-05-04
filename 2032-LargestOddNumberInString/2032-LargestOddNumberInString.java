// Last updated: 5/4/2026, 7:18:23 PM
class Solution {
    public String largestOddNumber(String num) {
        int to = num.length() - 1;
        for (; to >= 0; to--) {
            int digit = Integer.parseInt(num.charAt(to) + "");
            if (digit % 2 == 1) {
                break;
            }
        }

        if (to < 0) {
            return "";
        } else {
            return num.substring(0, to + 1);
        }
    }
}