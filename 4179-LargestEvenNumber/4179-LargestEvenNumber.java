// Last updated: 5/4/2026, 7:18:25 PM
class Solution {
    public String largestEven(String s) {
        if (s.isEmpty())
            return "";

        int i = s.length() - 1;
        if (s.charAt(i) % 2 == 0) {
            return s;
        } else {
            return largestEven(s.substring(0, i));
        }
    }
}